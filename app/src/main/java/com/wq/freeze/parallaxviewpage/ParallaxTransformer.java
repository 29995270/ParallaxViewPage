package com.wq.freeze.parallaxviewpage;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by wangqi on 2015/10/13.
 */
public class ParallaxTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();

        if (position < -1) { // [-Infinity,-1)

        } else if (position <= 0) { // [-1,0]
            view.setTranslationX(0);

        } else if (position <= 1) { // (0,1]
            view.setTranslationX(- pageWidth/2 + (pageWidth/2) * (1 - position));

        } else { // (1,+Infinity]
        }
    }
}
