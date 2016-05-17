package com.zss.example.performance.memory.image_handle.photo_wall;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.zss.example.performance.memory.image_handle.Images;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述：照片墙适配器
 * Created by Administrator on 2016/3/18 0018.
 */
public class PhotoWallAdapter extends ArrayAdapter<String> implements AbsListView.OnScrollListener {

    //记录所有正在下载或等待下载的任务
    private Set<BitmapWorkerTask> taskSet;
    //图片缓存的技术核心类，用户缓存所有下载好的图片，在程序达到设定值时会将最少最近不使用的移除掉
    private LruCache<String, Bitmap> memoryCache;
    //GridView实例
    private GridView gridView;
    //第一张可见图片的下标
    private int firstVisibleItem;
    //一屏幕有多少张图片可见
    private int visibleItemCount;
    //记录是否刚打开程序，用于解决进入程序不滚动屏幕，不会下载图片的问题
    private boolean isFirstEnter = true;


    public PhotoWallAdapter(Context context, int textViewResourceId, String[] objects,
                            GridView photoWall) {
        super(context, textViewResourceId, objects);
        gridView = photoWall;
        taskSet = new HashSet<>();
        //获取应用程序最大可用内存
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 8;
        //设置图片缓存大小为程序可用最大内存的1/8
        memoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
        gridView.setOnScrollListener(this);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String url = getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(com.zss.example.R.layout.activity_photo_wall_grid_item_layout, null);
        } else {
            view = convertView;
        }
        final ImageView imageView = (ImageView) view.findViewById(com.zss.example.R.id.imageView);
        //给ImageView设置Tag，保证异步加载时不会乱序
        imageView.setTag(url);
        setImageView(url, imageView);
        return view;
    }

    /**
     * 设置ImageView图片，先从Lrc中读取图片缓存，设置到ImageView上，如果没有，设置一张默认的图片
     */
    public void setImageView(String url, ImageView imageView) {
        Bitmap bitmap = getBitmapFromCache(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(com.zss.example.R.drawable.icon_qq);
        }
    }

    /**
     * 将一张图片缓存到LruCache中
     */
    public void addBitmapToCache(String url, Bitmap bitmap) {
        if (getBitmapFromCache(url) == null) {
            memoryCache.put(url, bitmap);
        }
    }

    /**
     * 从LruCache中获取一张图片，如果没有就返回null
     */
    public Bitmap getBitmapFromCache(String url) {
        return memoryCache.get(url);
    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.firstVisibleItem = firstVisibleItem;
        this.visibleItemCount = visibleItemCount;
        // 下载的任务应该由onScrollStateChanged里调用，但首次进入程序时onScrollStateChanged并不会调用，
        // 因此在这里为首次进入程序开启下载任务。
        if (isFirstEnter && visibleItemCount > 0) {
            loadBitmaps(firstVisibleItem, visibleItemCount);
            isFirstEnter = false;
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int state) {
        //仅当GridView静止时才加载图片，GridView滑动时取消所有任务
        if (state == SCROLL_STATE_IDLE) {
            loadBitmaps(firstVisibleItem, visibleItemCount);
        } else {
            cancelAllTask();
        }
    }

    /**
     * 加载Bitmap对象，此方法会在LruCache中检查所有屏幕中可见的ImageView的Bitmap对象，
     * 如果发现任何一个ImageView的Bitmap对象不存在缓存中，就会开启异步线程去下载图片
     */
    private void loadBitmaps(int firstVisibleItem, int visibleItemCount) {
        try {
            for (int i = firstVisibleItem; i < visibleItemCount + firstVisibleItem; i++) {
                String imageUrl = Images.imageThumbUrls[i];
                Bitmap bitmap = getBitmapFromCache(imageUrl);
                if (bitmap == null) {
                    BitmapWorkerTask task = new BitmapWorkerTask();
                    taskSet.add(task);
                    task.execute(imageUrl);
                } else {
                    ImageView imageView = (ImageView) gridView.findViewWithTag(imageUrl);
                    if (imageView != null && bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 取消所有正在下载或等待下载任务
     */
    public void cancelAllTask() {
        if (taskSet != null) {
            for (BitmapWorkerTask task : taskSet) {
                task.cancel(false);
            }
        }
    }

    /**
     * 异步下载图片的任务
     */
    class BitmapWorkerTask extends AsyncTask<String, Void, Bitmap> {
        //图片的URL地址
        private String imageUrl;

        @Override
        protected Bitmap doInBackground(String... params) {
            imageUrl = params[0];
            //在后台开始下载图片
            Bitmap bitmap = downloadBitmap(params[0]);
            if (bitmap != null) {
                //下载完图片之后缓存到LurCache中
                addBitmapToCache(params[0], bitmap);
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            //根据Tag找到相应的ImageView控件，将下载好的图片显示出来
            ImageView imageView = (ImageView) gridView.findViewWithTag(imageUrl);
            if (imageView != null && bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
            taskSet.remove(this);
        }

        /**
         * 建立http请求,获取bitmap
         */
        public Bitmap downloadBitmap(String imageUrl) {
            Bitmap bitmap = null;
            HttpURLConnection httpURLConnection = null;
            try {
                URL url = new URL(imageUrl);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(5 * 1000);
                httpURLConnection.setReadTimeout(10 * 1000);
                bitmap = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
            return bitmap;
        }
    }
}
