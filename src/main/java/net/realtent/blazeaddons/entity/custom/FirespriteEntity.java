package net.realtent.blazeaddons.entity.custom;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.EnumSet;

public class FirespriteEntity extends FlyingEntity implements Monster {
    private static final TrackedData<Integer> FUSE_SPEED = DataTracker.registerData(FirespriteEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private int lastFuseTime;
    private int currentFuseTime;
    private int fuseTime = 30;
    private int explosionRadius = 3;
    public FirespriteEntity(EntityType<? extends FirespriteEntity> entityType, World world) {

        super((EntityType<? extends FlyingEntity>)entityType, world);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0f);
        this.setPathfindingPenalty(PathNodeType.LAVA, 4.0f);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0f);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, 0.0f);
        this.moveControl = new FirespriteEntity.FirespriteMoveControl(this);
        this.experiencePoints = 2;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new FirespriteIgniteGoal(this));
        this.goalSelector.add(4, new FirespriteEntity.FirespriteAttackGoal(this));
        this.goalSelector.add(10, new FirespriteEntity.FlyRandomlyGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal<PlayerEntity>((MobEntity)this, PlayerEntity.class, true));
    }
    public static DefaultAttributeContainer.Builder createFirespriteAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5);
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(FUSE_SPEED, -1);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putShort("Fuse", (short)this.fuseTime);
        nbt.putByte("ExplosionRadius", (byte)this.explosionRadius);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("Fuse", NbtElement.NUMBER_TYPE)) {
            this.fuseTime = nbt.getShort("Fuse");
        }
        if (nbt.contains("ExplosionRadius", NbtElement.NUMBER_TYPE)) {
            this.explosionRadius = nbt.getByte("ExplosionRadius");
        }
    }

    @Override
    public void tick() {
        if (this.isAlive()) {
            int i;
            this.lastFuseTime = this.currentFuseTime;
            if ((i = this.getFuseSpeed()) > 0 && this.currentFuseTime == 0) {
                this.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0f, 0.5f);
                this.emitGameEvent(GameEvent.PRIME_FUSE);
            }
            this.currentFuseTime += i;
            if (this.currentFuseTime < 0) {
                this.currentFuseTime = 0;
            }
            if (this.currentFuseTime >= this.fuseTime) {
                this.currentFuseTime = this.fuseTime;
                this.explode();
            }
        }
        super.tick();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CREEPER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CREEPER_DEATH;
    }
    @Override
    public boolean tryAttack(Entity target) {
        return true;
    }
    public float getClientFuseTime(float timeDelta) {
        return MathHelper.lerp(timeDelta, (float)this.lastFuseTime, (float)this.currentFuseTime) / (float)(this.fuseTime - 2);
    }
    public int getFuseSpeed() {
        return this.dataTracker.get(FUSE_SPEED);
    }
    public void setFuseSpeed(int fuseSpeed) {
        this.dataTracker.set(FUSE_SPEED, fuseSpeed);
    }
    /* bottled
    this.destroy or smth
    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

            return ActionResult.success(this.getWorld().isClient);
        }
        return super.interactMob(player, hand);
    }

     */

    private void explode() {
        if (!this.getWorld().isClient) {
            this.dead = true;
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), (float)this.explosionRadius, World.ExplosionSourceType.MOB);
            this.discard();
            this.spawnEffectsCloud();
        }
    }
    private void spawnEffectsCloud() {
        Collection<StatusEffectInstance> collection = this.getStatusEffects();
        if (!collection.isEmpty()) {
            AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(this.getWorld(), this.getX(), this.getY(), this.getZ());
            areaEffectCloudEntity.setRadius(1.5f);
            areaEffectCloudEntity.setRadiusOnUse(-0.5f);
            areaEffectCloudEntity.setWaitTime(10);
            areaEffectCloudEntity.setDuration(areaEffectCloudEntity.getDuration() / 2);
            areaEffectCloudEntity.setRadiusGrowth(-areaEffectCloudEntity.getRadius() / (float)areaEffectCloudEntity.getDuration());
            for (StatusEffectInstance statusEffectInstance : collection) {
                areaEffectCloudEntity.addEffect(new StatusEffectInstance(statusEffectInstance));
            }
            this.getWorld().spawnEntity(areaEffectCloudEntity);
        }
    }
    static class FirespriteMoveControl
            extends MoveControl {
        private final FirespriteEntity firesprite;
        private int collisionCheckCooldown;

        public FirespriteMoveControl(FirespriteEntity firesprite) {
            super(firesprite);
            this.firesprite = firesprite;
        }

        @Override
        public void tick() {
            if (this.state != MoveControl.State.MOVE_TO) {
                return;
            }
            if (this.collisionCheckCooldown-- <= 0) {
                this.collisionCheckCooldown += this.firesprite.getRandom().nextInt(5) + 2;
                Vec3d vec3d = new Vec3d(this.targetX - this.firesprite.getX(), this.targetY - this.firesprite.getY(), this.targetZ - this.firesprite.getZ());
                double d = vec3d.length();
                if (this.willCollide(vec3d = vec3d.normalize(), MathHelper.ceil(d))) {
                    this.firesprite.setVelocity(this.firesprite.getVelocity().add(vec3d.multiply(0.05)));
                } else {
                    this.state = MoveControl.State.WAIT;
                }
            }
        }

        private boolean willCollide(Vec3d direction, int steps) {
            Box box = this.firesprite.getBoundingBox();
            for (int i = 1; i < steps; ++i) {
                box = box.offset(direction);
                if (this.firesprite.getWorld().isSpaceEmpty(this.firesprite, box)) continue;
                return false;
            }
            return true;
        }
    }
    public class FirespriteIgniteGoal
            extends Goal {
        private final FirespriteEntity firesprite;
        @Nullable
        private LivingEntity target;

        public FirespriteIgniteGoal(FirespriteEntity firesprite) {
            this.firesprite = firesprite;
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        @Override
        public boolean canStart() {
            LivingEntity livingEntity = this.firesprite.getTarget();
            return this.firesprite.getFuseSpeed() > 0 || livingEntity != null && this.firesprite.squaredDistanceTo(livingEntity) < 9.0;
        }

        @Override
        public void start() {
            this.firesprite.getNavigation().stop();
            this.target = this.firesprite.getTarget();
        }

        @Override
        public void stop() {
            this.target = null;
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            if (this.target == null) {
                this.firesprite.setFuseSpeed(-1);
                return;
            }
            if (this.firesprite.squaredDistanceTo(this.target) > 49.0) {
                this.firesprite.setFuseSpeed(-1);
                return;
            }
            if (!this.firesprite.getVisibilityCache().canSee(this.target)) {
                this.firesprite.setFuseSpeed(-1);
                return;
            }
            this.firesprite.setFuseSpeed(1);
        }
    }
    public class FirespriteAttackGoal
            extends AttackGoal {
        public FirespriteAttackGoal(FirespriteEntity firesprite) {
            super(firesprite);
        }
    }
    static class FlyRandomlyGoal
            extends Goal {
        private final FirespriteEntity firesprite;

        public FlyRandomlyGoal(FirespriteEntity firesprite) {
            this.firesprite = firesprite;
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        @Override
        public boolean canStart() {
            double f;
            double e;
            MoveControl moveControl = this.firesprite.getMoveControl();
            if (!moveControl.isMoving()) {
                return true;
            }
            double d = moveControl.getTargetX() - this.firesprite.getX();
            double g = d * d + (e = moveControl.getTargetY() - this.firesprite.getY()) * e + (f = moveControl.getTargetZ() - this.firesprite.getZ()) * f;
            return g < 1.0 || g > 3600.0;
        }

        @Override
        public boolean shouldContinue() {
            return false;
        }

        @Override
        public void start() {
            Random random = this.firesprite.getRandom();
            double d = this.firesprite.getX() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double e = this.firesprite.getY() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double f = this.firesprite.getZ() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.firesprite.getMoveControl().moveTo(d, e, f, 1.0);
        }
    }
}
