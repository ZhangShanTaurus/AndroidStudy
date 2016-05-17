package com.zss.example.helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.R;
import com.zss.example.common.CommonActivity;
import com.zss.example.common.Constance;
import com.zss.example.common.DataResource;
import com.zss.example.common.MyData;
import com.zss.example.data_parser.JsonParserActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：DataParserHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class DataParserHelper {

    public static void goNext(Context context, int index) {
        switch (index) {
            case R.string.json_parser:
                Bundle bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.json_parser);
                IntentUtils.intent(context, bundle, JsonParserActivity.class, false);
                break;
            case R.string.xml_parser:
                MyData myData = new MyData(R.string.xml_parser, new DataResource(Constance.DATA_XML_PARSER).getList(), Constance.DATA_XML_PARSER);
                bundle = new Bundle();
                bundle.putSerializable(Constance.MYDATA, myData);
                IntentUtils.intent(context, bundle, CommonActivity.class, false);
                break;
            default:
                break;
        }
    }
}
