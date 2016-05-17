package com.zss.example.data_parser;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 描述：JsonParserActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class JsonParserActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private TextView textView;
    private Button btn_parser;
    private String jsonString = "{\n" +
            "name:\"中国\",\n" +
            "province:[\n" +
            "   {\n" +
            "       name:\"黑龙江\",\n" +
            "       cites:{\n" +
            "               city:[\n" +
            "                   \"哈尔滨\",\"大庆\"\n" +
            "                    ]\n" +
            "             }\n" +
            "   }\n" +
            "]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parser_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        textView = (TextView) findViewById(R.id.textView);
        btn_parser = (Button) findViewById(R.id.btn_parser);
        btn_parser.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
        textView.setText(jsonString);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_parser:
                textView.setText(parserJson2String(jsonString));
                break;
            default:
                break;
        }
    }

    /**
     * 解析json字符串
     */
    private String parserJson2String(String jsonString) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            JSONObject objectOutSide = new JSONObject(jsonString);
            //国家
            String country = objectOutSide.getString("name");
            stringBuffer.append("国家:" + country + "--");
            //省份数组
            JSONArray province = objectOutSide.getJSONArray("province");

            for (int i = 0; i < province.length(); i++) {
                JSONObject objectInside = province.getJSONObject(i);
                //省的名字
                String provinceName = objectInside.getString("name");
                stringBuffer.append("省份:" + provinceName + "--");
                //省中的城市数组
                JSONObject objectCites = objectInside.getJSONObject("cites");
                //获取省中的城市
                JSONArray cityArray = objectCites.getJSONArray("city");

                for (int j = 0; j < cityArray.length(); j++) {
                    String cityName = cityArray.getString(j);
                    stringBuffer.append("City:" + j + cityName);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
