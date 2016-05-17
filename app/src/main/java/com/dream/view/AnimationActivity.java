package com.dream.view;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dream.app.R;
import com.dream.base.BaseActivity;
import com.dream.util.UtilLog;

/**
 * 动画练习.
 *
 * @author 李君波
 * @date 2015-9-26
 * @note 各种估值器
 * <p/>
 * 各种属性
 * <p/>
 * 答案是：任何一切带有set开头的方法属性名字。可能我们常用的有：
 * <p/>
 * 平移 translationX，translationY, X，Y
 * 缩放 scaleX，scaleY
 * 旋转 rotationX， rotationY
 * 透明度 alpha
 */
public class AnimationActivity extends BaseActivity {

    private LinearLayout container;
    private LayoutTransition mTransitioner;
    private int i = 0;
    private int j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        // 1 - ValueAnimator使用
        // ViewGroup viewGroup = (ViewGroup)findViewById(R.id.ll_root);
        // viewGroup.addView(new SingleLine(this));

        // 2 - ObjectAnimator使用
        // ImageView ivObj = (ImageView) findViewById(R.id.iv_obj_animator);
        // startAnimation(ivObj);

        // 3 - LayoutTransition使用
        container = (LinearLayout) findViewById(R.id.parent);
        initTransition();
        setTransition();
    }

    /**
     * 初始化容器动画
     */
    private void initTransition() {
        mTransitioner = new LayoutTransition();
        container.setLayoutTransition(mTransitioner);
    }

    private void setTransition() {
        /**
         * view出现时 view自身的动画效果
         */
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(null, "rotationY", 90F, 0F);
        animator1.setDuration(mTransitioner.getDuration(LayoutTransition.APPEARING));
        mTransitioner.setAnimator(LayoutTransition.APPEARING, animator1);

        /**
         * view 消失时，view自身的动画效果
         */
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(null, "rotationX", 0F, 90F, 0F);
        animator2.setDuration(mTransitioner.getDuration(LayoutTransition.DISAPPEARING));
        mTransitioner.setAnimator(LayoutTransition.DISAPPEARING, animator2);

        /**
         * view 动画改变时，布局中的每个子view执行动画移动位置或者状态的时间间隔
         */
        mTransitioner.setStagger(LayoutTransition.CHANGE_APPEARING, 240);
        mTransitioner.setStagger(LayoutTransition.CHANGE_DISAPPEARING, 240);

        /**
         * 为什么这里要这么写？具体我也不清楚，ViewGroup源码里面是这么写的，我只是模仿而已
         * 不这么写貌似就没有动画效果了，所以你懂的！
         */
        PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left", 0, 1);
        PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top", 0, 1);
        PropertyValuesHolder pvhRight = PropertyValuesHolder.ofInt("right", 0, 1);
        PropertyValuesHolder pvhBottom = PropertyValuesHolder.ofInt("bottom", 0, 1);

        /**
         * view出现时，导致整个布局改变的动画
         * 比如，在移除一个view的时候动画执行中，这时候，再去添加一个view，会出现。
         */
        PropertyValuesHolder animator3 = PropertyValuesHolder.ofFloat("scaleX", 1F, 2F, 1F);
        final ObjectAnimator changeIn = ObjectAnimator.ofPropertyValuesHolder(this, pvhLeft, pvhTop, pvhRight, pvhBottom, animator3);
        changeIn.setDuration(mTransitioner.getDuration(LayoutTransition.CHANGE_APPEARING));
        changeIn.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                View view = (View) ((ObjectAnimator) animation).getTarget();
                view.setScaleX(1.0f);
            }
        });
        mTransitioner.setAnimator(LayoutTransition.CHANGE_APPEARING, changeIn);

        /**
         * view消失，导致整个布局改变时的动画
         */
        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
        Keyframe kf1 = Keyframe.ofFloat(.5f, 2f);
        Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("scaleX", kf0, kf1, kf2);
        final ObjectAnimator changeOut = ObjectAnimator.ofPropertyValuesHolder(this, pvhLeft, pvhTop, pvhRight, pvhBottom, pvhRotation);
        changeOut.setDuration(mTransitioner.getDuration(LayoutTransition.CHANGE_DISAPPEARING));
        changeOut.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                View view = (View) ((ObjectAnimator) animation).getTarget();
                view.setScaleX(1.0f);
            }
        });
        mTransitioner.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, changeOut);
    }


    public void buttonClick(View view) {
        addButtonView();
    }

    public void buttonClick1(View view) {
        removeButtonView();
    }

    private void addButtonView() {
        i++;
        Button button = new Button(this);
        button.setText("button" + i);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        container.addView(button, params);
    }

    private void removeButtonView() {
        if (i > 0)
            container.removeViewAt(0);
    }

    /**********************************************
     * 【ObjectAnimator 使用】
     ***************************************************/

    private void startAnimation(View view) {
        // 平移
/*        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, 400.0f);
        animator1.setDuration(2500);
        animator1.setRepeatCount(-1);
        animator1.start();

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, 400.0f);
        animator2.setDuration(2500);
        animator2.setRepeatCount(-1);
        animator2.start();*/

        // 缩放
/*        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view,"scaleX",1.0f,2.0f);
        animator1.setRepeatCount(-1);
        animator1.setInterpolator(new BounceInterpolator());
        animator1.setDuration(2000).start();

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view,"scaleY",1.0f,2.0f);
        animator2.setRepeatCount(-1);
        animator2.setInterpolator(new BounceInterpolator());
        animator2.setDuration(2000).start();*/

        // 旋转
/*        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view,"rotationX",0.0f,180.0f);
        animator1.setRepeatCount(-1);
        animator1.setDuration(2000).start();

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view,"rotationY",0.0f,180.0f);
        animator2.setRepeatCount(-1);
        animator2.setDuration(2000).start();*/

        // 透明
/*        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.5f);
        animator.setRepeatCount(-1);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatMode(ValueAnimator.INFINITE);
        animator.setDuration(2000).start();*/

        // 组合动画 ① AnimatorSet的使用
/*        ObjectAnimator animator0 = ObjectAnimator.ofInt(view, "backgroundColor", 0xFFFF0000, 0xFFFF00FF);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, 200.0f, 0f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 2.0f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(view, "rotationX", 0.0f, 90.0f, 0.0F);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.2f, 1.0F);

        AnimatorSet set = new AnimatorSet();
        (set.play(animator0).with(animator1).before(animator2)).before(animator3).after(animator4);
        set.playTogether(animator1, animator3);
        set.setDuration(5000).start();*/

        // 组合动画 ② PropertyValuesHolder的使用
/*        PropertyValuesHolder valuesHolder0 = PropertyValuesHolder.ofFloat("translationX", 0.0f, 300.0f);
        PropertyValuesHolder valuesHolder1 = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 1.5f);
        PropertyValuesHolder valuesHolder2 = PropertyValuesHolder.ofFloat("rotationX", 0.0f, 90.0f, 0.0F);
        PropertyValuesHolder valuesHolder3 = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.3f, 1.0F);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, valuesHolder0, valuesHolder1, valuesHolder2, valuesHolder3);
        objectAnimator.setDuration(2000).start();*/

        // 利用Keyframe来实现如上动画效果
/*        Keyframe keyframe1 = Keyframe.ofFloat(0f, 0f);//第一帧动画 动画完成度0的时候的值是0
        Keyframe keyframe2 = Keyframe.ofFloat(.5f, 200.0f);//第二帧动画 动画完成度0.5也就是一半的时候值是200
        Keyframe keyframe3 = Keyframe.ofFloat(1f, 0f);//第三帧动画 动画完成度1也就是动画结束的时候值是0.

        PropertyValuesHolder property = PropertyValuesHolder.ofKeyframe("translationX", keyframe1, keyframe2, keyframe3);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, property);
        objectAnimator.setDuration(2500).start();*/

        // 多属性动画 ViewPropertyAnimator
/*        ViewPropertyAnimator animator = view.animate();
        animator.translationX(240).scaleX(2).setDuration(2000).start();*/

        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.anim_test);
        animator.setTarget(view);
        animator.start();

    }

    /**********************************************
     * 【ValueAnimator使用】
     ***************************************************/

    private void startAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 20);
        //ValueAnimator animator = ValueAnimator.ofFloat(0.0F, 10.0F);
        //ValueAnimator animator = ValueAnimator.ofArgb(0x00ffff,0x00ffee);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                //float value = (float)animation.getAnimatedValue();
                UtilLog.e("", "the value is " + value);
            }
        });
        animator.setDuration(1000);
        animator.start();
    }

    private class SingleLine extends View {

        private Paint mPaint;

        private float x = 0, y = 150;

        public SingleLine(Context context) {
            super(context);
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setColor(Color.RED);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (0 == x) {
                starAnimation();
            }
            canvas.drawLine(0, y, x, x + y, mPaint);
        }

        private void starAnimation() {
            ValueAnimator animator = ValueAnimator.ofObject(new SingleLineEvaluator(), 100, 500);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float i = (float) animation.getAnimatedValue();
                    x = i;
                    invalidate();
                }
            });
            animator.setDuration(2000);
            animator.start();
        }
    }

    private class SingleLineEvaluator implements TypeEvaluator {
        @Override
        public Object evaluate(float fraction, Object startValue, Object endValue) {

            UtilLog.e("", "the fraction value is " + fraction);
            UtilLog.e("", "the startValue value is " + startValue);
            UtilLog.e("", "the endValue value is " + endValue);

            return fraction * (((Number) endValue).floatValue() - ((Number) startValue).floatValue());
        }
    }
}
