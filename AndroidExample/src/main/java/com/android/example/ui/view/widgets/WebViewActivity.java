package com.android.example.ui.view.widgets;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.main.BaseActivity;

/**
 * 描述：WebViewActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class WebViewActivity extends BaseActivity {
    private ImageView iv_back;
    private TextView tv_title;
    private Button btn_call_js;
    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_layout);
        initView();
        initData();
        setWebView();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_call_js = (Button) findViewById(R.id.btn_call_js);
        webView = (WebView) findViewById(R.id.webView);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    public void setWebView() {
        //设置WebView可执行JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //提高渲染等级
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        //加载需要显示的网页
        webView.loadUrl("file:///android_asset/web_java_script.html");
        //声明允许JavaScript调用Android应用方法
        webView.addJavascriptInterface(WebViewActivity.this, "android");
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new MyWebViewClient());
        webView.setWebChromeClient(new MyWebChromeClient());
        //优先使用缓存
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }

    //设置回退
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();//表示WebView回退到上一步
            return true;
        }
        return false;
    }

    /**
     * Web视图
     */
    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //android调用JavaScript方法
            btn_call_js.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    webView.loadUrl("javascript:JSMethod()");
                }
            });
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
            return true;
        }
    }

    private class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
//                Toast.makeText(WebViewActivity.this, "页面加载完成", Toast.LENGTH_LONG).show();
            } else {

            }
        }
    }

    //4 供JS调用的方法(必须使用@JavascriptInterface注解)
    @JavascriptInterface
    public void callAndroidMethod() {
        Toast.makeText(this, "this is android method", Toast.LENGTH_SHORT).show();
    }
}
