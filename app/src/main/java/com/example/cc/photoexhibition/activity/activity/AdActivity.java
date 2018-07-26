package com.example.cc.photoexhibition.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.example.cc.photoexhibition.R;
import com.example.cc.photoexhibition.activity.adapter.ImageAdapter;
import com.example.cc.photoexhibition.activity.application.CirclePageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdActivity extends AppCompatActivity {

    private int[] GalImages = new int[]{

            R.drawable.a1,    //Here first,second,third... are the name of the jpeg files placed in drawable folder

            R.drawable.a2,

            R.drawable.a3
    };
    private static int NUM_PAGES = 0;
    private static int currentPage = 0;

    @BindView(R.id.btn_next)
    Button btn_next;

    Toolbar toolbar;
    TextView toolbar_Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        ButterKnife.bind(this);

        toolbar = findViewById(R.id.toolbar);
        toolbar_Title = toolbar.findViewById(R.id.toolbar_Title);
        toolbar_Title.setText("Advertisement");

        ViewPager viewPager = findViewById(R.id.view_pager);
        ImageAdapter adapter = new ImageAdapter(this, GalImages);
        viewPager.setAdapter(adapter);
        CirclePageIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        NUM_PAGES = GalImages.length;
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                currentPage = position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @OnClick(R.id.btn_next)
    public void btn_next() {
        Intent intent = new Intent(AdActivity.this, DashboardActivity.class);
        startActivity(intent);
    }
}
