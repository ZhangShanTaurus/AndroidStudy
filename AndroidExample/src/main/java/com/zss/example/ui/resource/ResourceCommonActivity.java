package com.zss.example.ui.resource;

import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * 描述：ResourceCommonActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class ResourceCommonActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView textView;
    private Button btn_shape;
    private TextView tv_raw;
    private MenuInflater menuInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zss.example.R.layout.activity_resource_common_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(com.zss.example.R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(com.zss.example.R.id.tv_title);
        textView = (TextView) findViewById(com.zss.example.R.id.textView);
        btn_shape = (Button) findViewById(com.zss.example.R.id.btn_shape);
        tv_raw = (TextView) findViewById(com.zss.example.R.id.tv_raw);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            int whichTitle = getIntent().getExtras().getInt(Constance.TITLE);
            tv_title.setText(whichTitle);
            switch (whichTitle) {
                case com.zss.example.R.string.anim1:
                    textView.setText(com.zss.example.R.string.resource_anim_info);
                    break;
                case com.zss.example.R.string.animator:
                    textView.setText(com.zss.example.R.string.resource_animator_info);
                    break;
                case com.zss.example.R.string.color:
                    textView.setText(com.zss.example.R.string.resource_color_info);
                    break;
                case com.zss.example.R.string.drawable:
                    btn_shape.setVisibility(View.VISIBLE);
                    textView.setText(com.zss.example.R.string.resource_drawable_info);
                    break;
                case com.zss.example.R.string.interpolator:
                    textView.setText(com.zss.example.R.string.resource_interpolator_info);
                    break;
                case com.zss.example.R.string.layout:
                    textView.setText(com.zss.example.R.string.resource_layout_info);
                    break;
                case com.zss.example.R.string.menu:
                    menuInflater = getMenuInflater();
                    textView.setText(com.zss.example.R.string.resource_menu_info);
                    break;
                case com.zss.example.R.string.raw:
                    tv_raw.setVisibility(View.VISIBLE);
                    tv_raw.setText(readStream(getResources().openRawResource(com.zss.example.R.raw.raw)));
                    textView.setText(com.zss.example.R.string.resource_raw_info);
                    break;
                case com.zss.example.R.string.values:
                    textView.setText(com.zss.example.R.string.resource_values_info);
                    break;
                case com.zss.example.R.string.xml:
                    tv_raw.setVisibility(View.VISIBLE);
                    XmlResourceParser parser = getResources().getXml(com.zss.example.R.xml.book);
                    tv_raw.setText(parser.getText() + "--xml解析");
                    textView.setText(com.zss.example.R.string.resource_xml_info);
                    break;
                default:
                    textView.setText(com.zss.example.R.string.title);
                    break;
            }
        }
    }

    /**
     * 读取raw文件下的文件信息
     */
    public String readStream(InputStream inputStream) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int i = inputStream.read();
            while (i != -1) {
                out.write(i);
                i = inputStream.read();
            }
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 读取raw文件夹下文件数据
     *
     * @param fileName
     * @return
     */
    public String getFromRaw(String fileName) {
        String res = "";

        try {
            InputStream in = getResources().openRawResource(com.zss.example.R.raw.raw);
            int length = in.available();
            byte[] buffer = new byte[length];
            in.read(buffer);
            res = buffer.toString();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case com.zss.example.R.id.iv_back:
                onBackPressed();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //通过配置文件创建菜单
        if (menuInflater != null) {
            menuInflater.inflate(com.zss.example.R.menu.reource_menu, menu);
        }
        return true;
    }
}
