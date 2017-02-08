package com.lipengfei.meishiyiyun.viewpagerhuanlangdemo;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        final List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.im_01);
        list.add(R.mipmap.img_02);
        list.add(R.mipmap.img_03);
        list.add(R.mipmap.img_04);
        MyAdapter myAdapter = new MyAdapter(list, this);
        //viewpager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.page_margin));
        viewpager.setOffscreenPageLimit(2);

        viewpager.setPageTransformer(true,new ZoomOutPageTransformer());
        viewpager.setAdapter(myAdapter);
    }
}
