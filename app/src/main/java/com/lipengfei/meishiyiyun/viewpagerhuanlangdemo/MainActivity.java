package com.lipengfei.meishiyiyun.viewpagerhuanlangdemo;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private ImageView img;
    private Button bt;
    private TextView tv;

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

        viewpager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewpager.setAdapter(myAdapter);


        bt = (Button) findViewById(R.id.bt);
        tv = (TextView) findViewById(R.id.tv);

        //时间对话框
        final DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tv.setText(year + "/" + (month + 1) + "/" + dayOfMonth);
            }
        }, 2010, 0, 1);

        //操作演示加载对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogStyle);
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.aleartdialog_item, null);
        final AlertDialog alertDialog = builder.setView(view).create();


        bt.setOnClickListener(new View.OnClickListener() {
            private AlertDialog dialog;

            @Override
            public void onClick(View v) {

            }
        });
    }
}
