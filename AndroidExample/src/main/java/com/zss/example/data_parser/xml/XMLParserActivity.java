package com.zss.example.data_parser.xml;

import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

import org.xmlpull.v1.XmlPullParser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * Created by Administrator on 2016/1/21 0021.
 */
public class XMLParserActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView textView;
    private TextView tv_info;//信息介绍
    private Button btn_parser;
    private int type = 1;
    private String xmlString = "<root> \n" +
            "    <item> \n" +
            "        <name>刘亦菲</name> \n" +
            "        <url>MingXing/LiuYiFei.htm</url> \n" +
            "        <color>red</color> \n" +
            "    </item> \n" +
            "    <item> \n" +
            "        <name>蔡依林</name> \n" +
            "        <url>MingXing/CaiYiLin.htm</url> \n" +
            "        <color>blue</color> \n" +
            "    </item> \n" +
            "</root>\n";
    private String string = "解析完成";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_parser_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        textView = (TextView) findViewById(R.id.textView);
        tv_info = (TextView) findViewById(R.id.tv_info);
        btn_parser = (Button) findViewById(R.id.btn_parser);
        btn_parser.setOnClickListener(this);
    }

    @Override
    public void initData() {
        textView.setText(xmlString);
        if (getIntent().getExtras() != null) {
            int resId = getIntent().getExtras().getInt(Constance.TITLE);
            tv_title.setText(resId);
            btn_parser.setText(resId);
            switch (resId) {
                case R.string.pull_parser:
                    tv_info.setText(R.string.pull_parser_info);
                    type = 1;
                    break;
                case R.string.sax_parser:
                    tv_info.setText(R.string.sax_parser_info);
                    type = 2;
                    break;
                case R.string.dom_parser:
                    tv_info.setText(R.string.dom_parser_info);
                    type = 3;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_parser:
                witchMethod(type);
                textView.setText(string);
                break;
            default:
                break;
        }
    }

    /**
     * 采用那种方式进行解析
     */
    private void witchMethod(int type) {
        if (type == 1) {
            usePullParser(xmlString);
        } else if (type == 2) {
            useSaxParser(xmlString);
        } else if (type == 3) {
            useDomParser(xmlString);
        } else {
            Toast.makeText(XMLParserActivity.this, "请选择一种解析方式", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 使用pull方式解析
     */
    private void usePullParser(String xml) {
        List<Star> list = null;
        Star star = null;
        //XMLPullParser.setInput()方法接收InputStream类型，故首先将String类型的XML数据转换成InputStream类型
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        XmlPullParser xmlPullParser = Xml.newPullParser();
        try {
            //XMLPullParser.setInput()方法接收InputStream类型
            xmlPullParser.setInput(inputStream, "UTF-8");
            //获取标签类型
            int type = xmlPullParser.getEventType();
            //若未读到最后的结束标签，则不停的遍历每个标签及其内容
            while (type != XmlPullParser.END_DOCUMENT) {
                switch (type) {
                    //若为xml起始标签，则实例化List对象
                    case XmlPullParser.START_DOCUMENT:
                        list = new ArrayList<>();
                        break;
                    //若读到每项的起始标签
                    case XmlPullParser.START_TAG:
                        //起始标签为item
                        if ("item".equals(xmlPullParser.getName())) {
                            //实例化Star对象
                            star = new Star();
                        } else if ("name".equals(xmlPullParser.getName())) {//起始标签为name
                            //后移一项
                            xmlPullParser.next();
                            //此时指向"name"标签的内容，将该内容设置到创建的Star对象中
                            star.setName(xmlPullParser.getText());
                        } else if ("url".equals(xmlPullParser.getName())) {
                            xmlPullParser.next();
                            star.setUrl(xmlPullParser.getText());
                        } else if ("color".equals(xmlPullParser.getName())) {
                            xmlPullParser.next();
                            star.setColor(xmlPullParser.getText());
                        }
                        break;
                    //若指向结束标签
                    case XmlPullParser.END_TAG:
                        //结束标签为"item"时，说明已读完一个完整的Star对象，该Star的所有字段已被赋值对象
                        if ("item".equals(xmlPullParser.getName())) {
                            list.add(star);
                        }
                        break;
                    default:
                        break;
                }
                type = xmlPullParser.next();
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (Star s : list) {
                stringBuffer.append("Name-" + s.getName() + "-Url-" + s.getUrl() + "-Color-" + s.getColor() + "\n");
            }
            string = stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用sax方式解析
     */
    private void useSaxParser(String xml) {

    }

    /**
     * 使用dom方式解析
     */
    private void useDomParser(String xml) {

    }

    private class Star {
        private String name;
        private String url;
        private String color;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Star:name-" + name + "-url-" + url + "-color-" + color;
        }
    }
}
