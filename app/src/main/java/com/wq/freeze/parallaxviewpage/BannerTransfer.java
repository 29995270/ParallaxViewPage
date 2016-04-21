package com.wq.freeze.parallaxviewpage;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by wangqi on 2016/4/20.
 */
public class BannerTransfer implements ViewPager.PageTransformer {

    private static final float MIN_SCALEY = 0.6f;
    private static final float MAX_SCALEY = 0.7f;
    private static final float MAX_SCALEX = 0.7f;
    private static final float MIN_SCALEX = 0.6f;

    @Override
    public void transformPage(View view, float position) {

        float pageWidth = view.getWidth();

        if (position < -1) { // [-Infinity,-1)
            //左边的页面在继续向左跑 从 -1 到 -2后就不再通知
            ViewCompat.setTranslationZ(view, -1f);
        } else if (position <= 0) { // [-1,0]
            //当前的页面向左跑 或左侧页向右跑

            view.setScaleX(position * (MAX_SCALEX - MIN_SCALEX) + MAX_SCALEX);
            view.setScaleY(position * (MAX_SCALEY - MIN_SCALEY) + MAX_SCALEY);
            view.setTranslationX(-pageWidth/2 + (pageWidth/2) * (1 - position));
            ViewCompat.setTranslationZ(view, position < -0.5? -1: 1);

        } else if (position <= 1) { // (0,1]
            //当前的页面向右跑 右侧页向左跑
            view.setScaleX(-position * (MAX_SCALEX - MIN_SCALEX) + MAX_SCALEX);
            view.setScaleY(-position * (MAX_SCALEY - MIN_SCALEY) + MAX_SCALEY);
            view.setTranslationX(-pageWidth/2 + (pageWidth/2) * (1 - position));
            ViewCompat.setTranslationZ(view, position > 0.5? -1 : 1);

        } else { // (1,+Infinity]
            //右边的页面在继续向右跑 从 1 到 2 后就不再通知
            ViewCompat.setTranslationZ(view, -1f);
        }

    }
}
