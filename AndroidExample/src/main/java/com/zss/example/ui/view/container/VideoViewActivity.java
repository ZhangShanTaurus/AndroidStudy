package com.zss.example.ui.view.container;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

import java.io.File;

/**
 * 描述：VideoViewActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class VideoViewActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private VideoView videoView;
    private MediaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoview_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(VideoViewActivity.this, "播放结束", Toast.LENGTH_SHORT).show();
            }
        });

        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                Toast.makeText(VideoViewActivity.this, "播放出现错误", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        controller = new MediaController(this);
        File file = new File("data/hello.mp4");
        if (file.exists()) {
            //VideoView与MediaController进行关联
            videoView.setVideoPath(file.getAbsolutePath());
            videoView.setMediaController(controller);
            controller.setMediaPlayer(videoView);
            //让VideoView获取焦点
            videoView.requestFocus();
        } else {
            Toast.makeText(this, "音频文件不存在", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            default:
                break;
        }
    }
}
