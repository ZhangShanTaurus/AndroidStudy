package com.android.example.communication.http;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：HttpConnectionActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class HttpConnectionActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_get;
    private Button btn_post;
    private static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_connection_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_get = (Button) findViewById(R.id.btn_get);
        btn_get.setOnClickListener(this);
        btn_post = (Button) findViewById(R.id.btn_post);
        btn_post.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_get:
                result = "";
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        result = httpByGet();
                    }
                }).start();
                break;
            case R.id.btn_post:
                result = "";
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        result = httpByPost();
                    }
                }).start();
                break;
            default:
                break;
        }
    }

    private String str_post = "http://2ciyuanjie.com/api.php";
    private String str_get = "http://2ciyuanjie.com/api.php?token=866001029216760&apiUrl=getoken&apiVersion=K10";
    private URL url;
    private HttpURLConnection urlConnection;
    private String result;

    /**
     * Get请求
     */
    public String httpByGet() {
        try {
            url = new URL(str_get);
            urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String response = "";
            while ((response = reader.readLine()) != null) {
                result += response;
            }
            reader.close();
            urlConnection.disconnect();
            return result;
        } catch (Exception e) {
            result = "连接超时";
            e.printStackTrace();
            return null;
        } finally {
            Message mg = Message.obtain();
            mg.obj = result;
            handler.sendMessage(mg);
        }
    }

    /**
     * Post请求
     */
    public String httpByPost() {
        try {
            url = new URL(str_post);
            urlConnection = (HttpURLConnection) url.openConnection();
            //设置输入和输出流
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            //设置请求方式
            urlConnection.setRequestMethod("POST");
            //设置缓存
            urlConnection.setUseCaches(false);
            //配置本次连接的Content-type，配置为application/x-www-form-urlencoded
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

//            //DataOutputStream
//            DataOutputStream dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
//            //请求正文,即要上传的参数
//            String content = "token=866001029216760&apiUrl=getoken&apiVersion=K10";
//            //将要上传的内容写入流中
//            dataOutputStream.writeBytes(content);
//            //刷新，关闭
//            dataOutputStream.flush();
//            dataOutputStream.close();

            List<NameValuePair> postParams = new ArrayList<>();
            //要传递的参数
            postParams.add(new BasicNameValuePair("token", "866001029216760"));
            postParams.add(new BasicNameValuePair("apiUrl", "getoken"));
            postParams.add(new BasicNameValuePair("apiVersion", "K10"));
            postParams(urlConnection.getOutputStream(), postParams);

            //连接，urlConnection.openConnection()至此的配置必须要在urlConnection.connect()之前完成，要注意的是connection.getOutputStream()会隐含的进行connect。
            urlConnection.connect();

            //获取服务端返回的信息
            InputStream is = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String response = "";
            while ((response = bufferedReader.readLine()) != null) {
                result += response;
            }
            is.close();
            reader.close();
            bufferedReader.close();
            //断开连接
            urlConnection.disconnect();
            return result;
        } catch (Exception e) {
            result = "连接超时";
            e.printStackTrace();
            return null;
        } finally {
            Message mg = Message.obtain();
            mg.obj = result;
            handler.sendMessage(mg);
        }
    }


    /**
     * 用来组织一下请求参数并将请求参数写入到输出流中
     */
    public void postParams(OutputStream output, List<NameValuePair> paramsList) throws IOException {
        StringBuilder mStringBuilder = new StringBuilder();
        for (NameValuePair pair : paramsList) {
            if (!TextUtils.isEmpty(mStringBuilder)) {
                mStringBuilder.append("&");
            }
            mStringBuilder.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            mStringBuilder.append("=");
            mStringBuilder.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, "UTF-8"));
        Log.e("", "请求参数为:" + mStringBuilder.toString());
        writer.write(mStringBuilder.toString());
        writer.flush();
        writer.close();
    }

    private MyHandler handler = new MyHandler(HttpConnectionActivity.this);

    private static class MyHandler extends Handler {
        private WeakReference<HttpConnectionActivity> weakReference;

        public MyHandler(HttpConnectionActivity activity) {
            weakReference = new WeakReference<HttpConnectionActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textView.setText(msg.obj.toString());
        }
    }
}
