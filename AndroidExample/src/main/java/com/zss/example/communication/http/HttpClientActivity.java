package com.zss.example.communication.http;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：HttpClientActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class HttpClientActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_get;
    private Button btn_post;
    private static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_client_layout);
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
                        useHttpClientGet(str_get);
                    }
                }).start();
                break;
            case R.id.btn_post:
                result = "";
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        useHttpClientPost(str_post);
                    }
                }).start();
                break;
            default:
                break;
        }
    }

    private String str_post = "http://2ciyuanjie.com/api.php";
    private String str_get = "http://2ciyuanjie.com/api.php?token=866001029216760&apiUrl=getoken&apiVersion=K10";
    private String result;

    /**
     * 创建HttpClient
     */
    public HttpClient createHttpClient() {
        HttpParams mDefaultHttpParams = new BasicHttpParams();
        //设置连接超时
        HttpConnectionParams.setConnectionTimeout(mDefaultHttpParams, 15000);
        //设置请求超时
        HttpConnectionParams.setSoTimeout(mDefaultHttpParams, 15000);
        HttpConnectionParams.setTcpNoDelay(mDefaultHttpParams, true);
        HttpProtocolParams.setVersion(mDefaultHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(mDefaultHttpParams, HTTP.UTF_8);
        //持续握手
        HttpProtocolParams.setUseExpectContinue(mDefaultHttpParams, true);
        HttpClient mHttpClient = new DefaultHttpClient(mDefaultHttpParams);
        return mHttpClient;
    }

    /**
     * 使用HttpClient的Get请求
     */
    public void useHttpClientGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Connection", "Keep-Alive");
        try {
            HttpClient httpClient = createHttpClient();
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            int code = httpResponse.getStatusLine().getStatusCode();
            if (null != entity) {
                InputStream inputStream = entity.getContent();
                result = convertStreamToString(inputStream);
                Log.e("", "请求状态码:" + code + "\n请求结果:\n" + result);
                inputStream.close();
            }
        } catch (Exception e) {
            result = "连接超时";
            e.printStackTrace();
        } finally {
            Message message = Message.obtain();
            message.obj = result;
            handler.sendMessage(message);
        }
    }

    /**
     * 使用HttpClient的Post请求
     */
    private void useHttpClientPost(String url) {
        HttpPost mHttpPost = new HttpPost(url);
        mHttpPost.addHeader("Connection", "Keep-Alive");
        try {
            HttpClient mHttpClient = createHttpClient();
            List<NameValuePair> postParams = new ArrayList<>();
            //要传递的参数
            postParams.add(new BasicNameValuePair("token", "866001029216760"));
            postParams.add(new BasicNameValuePair("apiUrl", "getoken"));
            postParams.add(new BasicNameValuePair("apiVersion", "K10"));
            mHttpPost.setEntity(new UrlEncodedFormEntity(postParams));
            HttpResponse mHttpResponse = mHttpClient.execute(mHttpPost);
            HttpEntity mHttpEntity = mHttpResponse.getEntity();
            int code = mHttpResponse.getStatusLine().getStatusCode();
            if (null != mHttpEntity) {
                InputStream mInputStream = mHttpEntity.getContent();
                result = convertStreamToString(mInputStream);
                Log.e("", "请求状态码:" + code + "\n请求结果:\n" + result);
                mInputStream.close();
            }
        } catch (IOException e) {
            result = "连接超时";
            e.printStackTrace();
        } finally {
            Message message = Message.obtain();
            message.obj = result;
            handler.sendMessage(message);
        }
    }


    /**
     * 把Stream数据转换为String
     */
    private String convertStreamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuffer sb = new StringBuffer();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        String response = sb.toString();
        return response;
    }

    private MyHandler handler = new MyHandler(this);

    /**
     * 静态内部类Handler，防止内存泄漏，使用弱引用
     */
    private static class MyHandler extends Handler {
        private WeakReference<HttpClientActivity> activity;

        public MyHandler(HttpClientActivity activity) {
            this.activity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            textView.setText(msg.obj.toString());
        }
    }
}
