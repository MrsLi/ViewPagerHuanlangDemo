package com.lipengfei.meishiyiyun.viewpagerhuanlangdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.Pools;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by meishiyiyun on 2017/2/7.
 */

public class MyAdapter extends PagerAdapter {
    private List<Integer> listId;
    private Context context;
    private final Pools.Pool<ImageView> pool;

    public MyAdapter(List<Integer> listId, Context context) {
        this.listId = listId;
        this.context = context;
        pool = new Pools.SimplePool<>(4);
    }

    @Override
    public int getCount() {
        return listId.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = pool.acquire();
        if (imageView == null) {
            imageView = new ImageView(context);
        }
        //imageView.setPadding(50,50,50,50);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Bitmap bitmap = ImageUtils.drawableToBitmap(context.getDrawable(listId.get(position)));
        bitmap = ImageUtils.getRoundedCornerBitmap(bitmap,30.0f);
       imageView.setImageBitmap(bitmap);

        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        pool.release((ImageView) object);
    }
}