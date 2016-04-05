package com.android.example.performance.memory.image_handle.fall_wall;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.performance.memory.image_handle.Images;
import com.android.example.performance.memory.image_handle.multipoint_touch.MultipointTouchActivity;
import com.android.example.utils.IntentUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 描述：MyScrollView
 * Created by Administrator on 2016/3/18 0018.
 */
public class MyScrollView extends ScrollView implements View.OnTouchListener {
    //每页要加载的图片数量
    public static final int PAGE_SIZE = 15;
    //记录当前已加载到第几页
    private int pageIndex;
    //每一列的宽度
    private int columnWidth;
    //当前第一列的高度
    private int firstColumnHeight;
    //当前第二列高度
    private int secondColumnHeight;
    //当前第三列的高度
    private int thirdColumnHeight;
    //是否加载过一次layout，这里onLayout中的初始化只需加载一次
    private boolean loadOnce;
    //对图片进行管理 的工具类
    private ImageLoader imageLoader;
    //第一列布局
    private LinearLayout firstColumn;
    //第二列布局
    private LinearLayout secondColumn;
    //第三列布局
    private LinearLayout thirdColumn;
    //记录所有正在下载或等待的任务
    private static Set<LoadImageTask> taskCollection;
    //MyScroll下的直接子布局
    private static View scrollLayout;
    //MyScrollView布局的高度
    private static int scrollViewHeight;
    //记录上垂直高度滚动的距离
    private static int lastScrollY;
    //记录所有界面上的图片，用于可以随时控制对图片的释放
    private List<ImageView> imageViewList = new ArrayList<>();
    //在handler中进行对图片可见性检查判断，以及加载更多图片的操作
    private static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MyScrollView myScrollView = (MyScrollView) msg.obj;
            int scrollY = myScrollView.getScrollY();
            //如果当前的滚动位置和上次相同，表示停止滚动
            if (scrollY == lastScrollY) {
                // 当滚动的最底部，并且当前没有正在下载的任务时，开始加载下一页的图片
                if (scrollViewHeight + scrollY >= scrollLayout.getHeight() && taskCollection.isEmpty()) {
                    myScrollView.loadMoreImages();
                }
                myScrollView.checkVisibility();
            } else {
                lastScrollY = scrollY;
                Message message = new Message();
                message.obj = myScrollView;
                handler.sendMessageDelayed(message, 5);
            }
        }
    };

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        imageLoader = ImageLoader.getImageLoader();
        taskCollection = new HashSet<>();
        setOnTouchListener(this);
    }

    //进行一些关键性的初始化操作，获取MyScrollView的高度，以及得到第一列的宽度值，并在这里开始加载第一页图片
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed && !loadOnce) {
            scrollViewHeight = getHeight();
            scrollLayout = getChildAt(0);
            firstColumn = (LinearLayout) findViewById(R.id.first_column);
            secondColumn = (LinearLayout) findViewById(R.id.second_column);
            thirdColumn = (LinearLayout) findViewById(R.id.third_column);
            columnWidth = firstColumn.getWidth();
            loadOnce = true;
            loadMoreImages();
        }
    }

    /**
     * 监听用户的触屏事件，如果用户手指离开屏幕则进行滚动检测
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            Message message = Message.obtain();
            message.obj = this;
            handler.sendMessageDelayed(message, 5);
        }
        return false;
    }

    /**
     * 开始加载下一页图片，每张图片都会开启一个异步线程去下载
     */
    private void loadMoreImages() {
        if (hasSDCard()) {
            int startIndex = pageIndex * PAGE_SIZE;
            int endIndex = pageIndex * PAGE_SIZE + PAGE_SIZE;
            if (startIndex < Images.imageThumbUrls.length) {
                Toast.makeText(getContext(), "正在加载", Toast.LENGTH_SHORT).show();
                if (endIndex > Images.imageThumbUrls.length) {
                    endIndex = Images.imageThumbUrls.length;
                }
                for (int i = startIndex; i < endIndex; i++) {
                    LoadImageTask task = new LoadImageTask();
                    taskCollection.add(task);
                    task.execute(Images.imageThumbUrls[i]);
                }
                pageIndex++;
            } else {
//                Toast.makeText(getContext(), "已没有更多图片", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getContext(), "未发现SD卡", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 遍历ImageViewList中每张图片，对每张图片的可见性进行检查，如果图片离开屏幕可见范围，将图片替换为一张空图
     */
    public void checkVisibility() {
        for (int i = 0; i < imageViewList.size(); i++) {
            ImageView imageView = imageViewList.get(i);
            int top = (Integer) imageView.getTag(R.string.border_top);
            int bottom = (Integer) imageView.getTag(R.string.border_bottom);
            if (bottom > getScrollY() && top < getScrollY() + scrollViewHeight) {
                String imageUrl = (String) imageView.getTag(R.string.image_url);
                Bitmap bitmap = imageLoader.getBitmapFromCache(imageUrl);
                if (bitmap == null) {
                    LoadImageTask task = new LoadImageTask(imageView);
                    task.execute(imageUrl);
                } else {
                    imageView.setImageBitmap(bitmap);
                }
            } else {
                imageView.setImageResource(R.drawable.icon_qq);
            }
        }
    }

    /**
     * 判断手机是否有SD卡
     * 有返回true
     */
    private boolean hasSDCard() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }


    class LoadImageTask extends AsyncTask<String, Void, Bitmap> {
        //图片的url
        private String imageUrl;
        //可重复利用的ImageView
        private ImageView imageView;

        public LoadImageTask() {
        }

        //将可重复使用的ImageView传入
        public LoadImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            imageUrl = strings[0];
            Bitmap bitmap = imageLoader.getBitmapFromCache(imageUrl);
            if (bitmap == null) {
                bitmap = loadImage(imageUrl);
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap != null) {
                double ratio = bitmap.getWidth() / (columnWidth * 1.0);
                int scaleHeight = (int) (bitmap.getHeight() / ratio);
                addImage(bitmap, columnWidth, scaleHeight);
            }
            taskCollection.remove(this);
        }

        /**
         * 向ImageView中添加图片
         */
        private void addImage(final Bitmap bitmap, int imageWidth, int imageHeight) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(imageWidth, imageHeight);
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                imageView = new ImageView(getContext());
                imageView.setLayoutParams(layoutParams);
                imageView.setImageBitmap(bitmap);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setPadding(5, 5, 5, 5);
                imageView.setTag(R.string.image_url, imageUrl);
                //点击图片跳转到多点触控页面
                imageView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putInt(Constance.TITLE, R.string.title);
                        bundle.putString("imageUrl", getImagePath(imageUrl));
                        IntentUtils.intent(getContext(), bundle, MultipointTouchActivity.class, false);
                    }
                });
                findColumnToAdd(imageView, imageHeight).addView(imageView);
                imageViewList.add(imageView);
            }
        }

        /**
         * 找到此时应该添加图片的一列，原则就是对三列的高度进行判断
         * 当前高度最小的一列就是应该添加的一列
         */
        private LinearLayout findColumnToAdd(ImageView imageView, int imageHeight) {
            if (firstColumnHeight <= secondColumnHeight) {
                if (firstColumnHeight <= thirdColumnHeight) {
                    imageView.setTag(R.string.border_top, firstColumnHeight);
                    firstColumnHeight += imageHeight;
                    imageView.setTag(R.string.border_bottom, firstColumnHeight);
                    return firstColumn;
                }
                imageView.setTag(R.string.border_top, thirdColumnHeight);
                thirdColumnHeight += imageHeight;
                imageView.setTag(R.string.border_bottom, thirdColumnHeight);
                return thirdColumn;
            } else {
                if (secondColumnHeight <= thirdColumnHeight) {
                    imageView.setTag(R.string.border_top, secondColumnHeight);
                    secondColumnHeight += imageHeight;
                    imageView
                            .setTag(R.string.border_bottom, secondColumnHeight);
                    return secondColumn;
                }
                imageView.setTag(R.string.border_top, thirdColumnHeight);
                thirdColumnHeight += imageHeight;
                imageView.setTag(R.string.border_bottom, thirdColumnHeight);
                return thirdColumn;
            }
        }

        /**
         * 根据传入的URL对图片进行加载，如果图片存在SD卡中就直接读取，否则从网络上下载
         */
        public Bitmap loadImage(String imageUrl) {
            File imageFile = new File(getImagePath(imageUrl));
            //SD卡里没有直接下载
            if (!imageFile.exists()) {
                downLoadImage(imageUrl);
            }
            if (imageUrl != null) {
                Bitmap bitmap = ImageLoader.decodeSampleBitmapFromResource(imageFile.getPath(), columnWidth);
                if (bitmap != null) {
                    imageLoader.addBitmapToCache(imageUrl, bitmap);
                    return bitmap;
                }
            }
            return null;
        }

        /**
         * 下载图片保存本地缓存起来
         */
        private void downLoadImage(String imageUrl) {
            HttpURLConnection httpURLConnection = null;
            FileOutputStream fileOutputStream = null;
            BufferedOutputStream bufferedOutputStream = null;
            BufferedInputStream bufferedInputStream = null;
            File imageFile = null;
            try {
                URL url = new URL(imageUrl);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(5 * 1000);
                httpURLConnection.setReadTimeout(15 * 1000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                //创建图片文件
                imageFile = new File(getImagePath(imageUrl));
                fileOutputStream = new FileOutputStream(imageFile);
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                byte b[] = new byte[1024];
                int length;
                while ((length = bufferedInputStream.read(b)) != -1) {
                    bufferedOutputStream.write(b, 0, length);
                    bufferedOutputStream.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (imageFile != null) {
                Bitmap bitmap = ImageLoader.decodeSampleBitmapFromResource(imageFile.getPath(), columnWidth);
                if (bitmap != null) {
                    imageLoader.addBitmapToCache(imageUrl, bitmap);
                }
            }
        }

        /**
         * 获取图片本地存储路径
         */
        public String getImagePath(String imageUrl) {
            int lastIndex = imageUrl.lastIndexOf("/");
            String imageName = imageUrl.substring(lastIndex + 1);
            String imageDir = Environment.getExternalStorageDirectory().getPath() + "/PhotoWallFalls/";
            //创建文件夹
            File file = new File(imageDir);
            if (!file.exists()) {
                file.mkdir();
            }
            String imagePath = imageDir + imageName;
            return imagePath;
        }
    }
}
