package com.android.example.helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.CommonActivity;
import com.android.example.common.Constance;
import com.android.example.common.DataResource;
import com.android.example.common.MyData;
import com.android.example.data_parser.JsonParserActivity;
import com.android.example.utils.IntentUtils;

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
