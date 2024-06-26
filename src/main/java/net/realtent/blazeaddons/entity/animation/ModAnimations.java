package net.realtent.blazeaddons.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class ModAnimations {


    public static final Animation FIRESPRITE_IDLE = Animation.Builder.create(0.6766666f).looping()
            .addBoneAnimation("NS",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(180f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(360f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("WE",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(0f, 0f, 180f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(0f, 0f, 360f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("maincube",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0.041676664f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.3433333f, AnimationHelper.createTranslationalVector(0f, 4f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.625f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
    public static final Animation FIRESPRITE_WALK = Animation.Builder.create(0.6766666f).looping()
            .addBoneAnimation("NS",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(180f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(360f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("WE",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(0f, 0f, 180f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(0f, 0f, 360f),
                                    Transformation.Interpolations.LINEAR))).build();
    public static final Animation FIRESPRITE_EXPLODE = Animation.Builder.create(1.3433333f).looping()
            .addBoneAnimation("NS",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(180f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(360f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(540f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.3433333f, AnimationHelper.createRotationalVector(720f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("WE",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(0f, 0f, 180f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(0f, 0f, 360f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, 540f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.3433333f, AnimationHelper.createRotationalVector(0f, 0f, 720f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("maincube",
                    new Transformation(Transformation.Targets.SCALE,
                            new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createScalingVector(0.3f, 0.3f, 0.3f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.3433333f, AnimationHelper.createScalingVector(5f, 5f, 5f),
                                    Transformation.Interpolations.LINEAR))).build();
}
