package com.zss.example.base_knowledge.service.sample;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.zss.example.base_knowledge.service.IntentServiceActivity;

/**
 * 描述：UploadImgService
 * Created by Administrator on 2016/2/29 0029.
 */
public class UploadImgService extends IntentService {
    private static final String ACTION_UPLOAD_IMG = "com.android.example.base_knowledge.action.UPLOAD_IMAGE";
    public static final String EXTRA_IMG_PATH = "com.android.example.base_knowledge.extra.IMG_PATH";

    public UploadImgService() {
        super("UploadImgService");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(), "UploadImgService--onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "UploadImgService--onDestroy()", Toast.LENGTH_SHORT).show();
    }

    /**
     * 复写onHandleIntent方法
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_UPLOAD_IMG.equals(action)) {
                final String path = intent.getStringExtra(EXTRA_IMG_PATH);
                handleUploadImg(path);
            }
        }
    }

    /**
     * 上传图片
     */
    public static void startUploadImg(Context context, String path) {
        Intent intent = new Intent(context, UploadImgService.class);
        intent.setAction(ACTION_UPLOAD_IMG);
        intent.putExtra(EXTRA_IMG_PATH, path);
        context.startService(intent);
    }

    private void handleUploadImg(String path) {
        try {
            //模拟耗时上传
            Thread.sleep(3000);
            Intent intent = new Intent(IntentServiceActivity.UPLOAD_RESULT);
            intent.putExtra(EXTRA_IMG_PATH, path);
            sendBroadcast(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
