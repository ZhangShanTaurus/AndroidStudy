package com.zss.example.performance.memory.image_handle.fall_wall;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;

/**
 * 描述：ImageLoader
 * Created by Administrator on 2016/3/18 0018.
 */
public class ImageLoader {
    //图片缓存技术核心类，用于缓存所有下载好的图片，在程序达到设定值时会将最近最少使用的图片移除
    private static LruCache<String, Bitmap> lruCache;
    //ImageLoader实例
    private static ImageLoader imageLoader;

    private ImageLoader() {
        //获取应用最大可用内存
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheMemory = maxMemory / 8;
        lruCache = new LruCache<String, Bitmap>(cacheMemory) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
    }

    /**
     * 获取imageLoader实例
     */
    public static ImageLoader getImageLoader() {
        if (imageLoader == null) {
            imageLoader = new ImageLoader();
        }
        return imageLoader;
    }

    /**
     * 将一张图片缓存到LruCache中
     */
    public void addBitmapToCache(String key, Bitmap value) {
        if (getBitmapFromCache(key) == null) {
            lruCache.put(key, value);
        }
    }

    /**
     * 从LruCache中获取一张图片
     */
    public Bitmap getBitmapFromCache(String key) {
        return lruCache.get(key);
    }

    /**
     * 计算InSampleSize的值
     */
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth) {
        //源图片的宽度
        int width = options.outWidth;
        int inSampleSize = 1;
        if (width > reqWidth) {
            //计算出实际宽度与目标宽度的比例
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = widthRatio;
        }
        return inSampleSize;
    }

    public static Bitmap decodeSampleBitmapFromResource(String path, int reqWidth) {
        //第一次解析将inJustDecodeBounds设置为true,来获取图片大小
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        //计算inSampleSize的值
        options.inSampleSize = calculateInSampleSize(options, reqWidth);
        //使用计算的inSampleSize的值再次解析图片
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(path, options);
    }
}
