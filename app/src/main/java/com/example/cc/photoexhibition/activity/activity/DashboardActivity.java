package com.example.cc.photoexhibition.activity.activity;

import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.cc.photoexhibition.R;
import com.example.cc.photoexhibition.activity.adapter.ImageAdapter;
import com.example.cc.photoexhibition.activity.application.CirclePageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardActivity extends AppCompatActivity {

    private int[] GalImages = new int[]{

            R.drawable.c1,    //Here first,second,third... are the name of the jpeg files placed in drawable folder
            R.drawable.c2,
            R.drawable.c3,
            R.drawable.c4,
            R.drawable.c5,
            R.drawable.c6,
            R.drawable.c7
    };
    private static int NUM_PAGES = 0;
    private static int currentPage = 0;

    @BindView(R.id.img_like)
    ImageView img_like;

    Integer counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        ViewPager viewPager = findViewById(R.id.view_pager);
        ImageAdapter adapter = new ImageAdapter(this, GalImages);
        viewPager.setAdapter(adapter);
        CirclePageIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        NUM_PAGES =GalImages.length;
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                currentPage = position;
                counter = 1;
                img_like.setColorFilter(ContextCompat.getColor(DashboardActivity.this,R.color.white), PorterDuff.Mode.MULTIPLY);
            }

            @Override
            public void onPageSelected(int positoion) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    @OnClick(R.id.img_like)
    public void img_like(){
        counter++;
        if(counter%2==0){
            img_like.setColorFilter(ContextCompat.getColor(this,R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
        }else{
            img_like.setColorFilter(ContextCompat.getColor(this,R.color.white), PorterDuff.Mode.MULTIPLY);
        }
    }
}
