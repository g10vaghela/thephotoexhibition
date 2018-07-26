package com.example.cc.photoexhibition.activity.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cc.photoexhibition.R;

/**
 * Created by cc on
 * 7/20/2018.
 */

public class ImageAdapter extends PagerAdapter {

    private Context context;
    private int[] GalImages;

    public ImageAdapter(Context context,int[] GalImages) {

        this.context = context;
        this.GalImages = GalImages;

    }

    @Override
    public int getCount() {
        return GalImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override

    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);


        imageView.setImageResource(GalImages[position]);

        container.addView(imageView, 0);

        return imageView;

    }

    @Override

    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((ImageView) object);

    }
}
