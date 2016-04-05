package com.android.example.communication.socket;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.net.Socket;

/**
 * 描述：
 * Created by Administrator on 2016/1/21 0021.
 */
public class SocketActivity extends BaseActivity implements View.OnClickListener, Runnable {
    private ImageView iv_back;
    private TextView tv_title;
    private EditText et_message;
    private static TextView textView;
    private Button btn_send;

    private Socket socket;
    private static final String HOST = "192.168.1.13";//主机地址
    private static final int PORT = 9996;//端口
    private BufferedReader bufferedReader = null;
    private PrintWriter printWriter = null;
    private static String content = "";

    private MyHandler handler = new MyHandler(SocketActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        textView = (TextView) findViewById(R.id.textView);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(this);
        et_message = (EditText) findViewById(R.id.et_message);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 与服务端建立连接
                    socket = new Socket(HOST, PORT);
                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                    content = "连接服务器成功";
                } catch (Exception e) {
                    e.printStackTrace();
                    content = "连接服务器失败";
                }
                handler.sendMessage(handler.obtainMessage());
            }
        }).start();
    }

    /**
     * 发送消息
     */
    public void send() {
        String message = et_message.getText().toString();
        if (TextUtils.isEmpty(message)) {
            Toast.makeText(SocketActivity.this, "请输入消息", Toast.LENGTH_SHORT).show();
            return;
        }
        if (socket == null) {
            content = "连接服务器失败";
            handler.sendMessage(handler.obtainMessage());
            return;
        }
        if (socket.isConnected()) {
            if (!socket.isOutputShutdown()) {
                printWriter.print(message);
            }
        }
        //启动线程，接收服务器发送过来的数据
        new Thread(SocketActivity.this).start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_send:
                send();
                break;
            default:
                break;
        }
    }

    /**
     * 读取服务器发来的信息，并通过Handler发送给UI线程
     */
    @Override
    public void run() {
        try {
            while (true) {
                if (!socket.isClosed()) {
                    if (socket.isConnected()) {
                        if (!socket.isInputShutdown()) {
                            if ((content = bufferedReader.readLine()) != null) {
                                content += "\n";
                                handler.sendMessage(handler.obtainMessage());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 静态内部类，防止内存泄漏
     */
    private static class MyHandler extends Handler {
        private final WeakReference<SocketActivity> weakReference;

        public MyHandler(SocketActivity activity) {
            this.weakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textView.setText(content);
        }
    }
}
