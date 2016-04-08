package com.android.example.helper.data_parser_helper;

import android.content.Context;
import android.os.Bundle;

import com.android.example.R;
import com.android.example.common.Constance;
import com.android.example.data_parser.xml.XMLParserActivity;
import com.android.example.data_parser.xml.XMLBaseInfoActivity;
import com.android.example.utils.IntentUtils;

/**
 * 描述：XMLParserHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class XMLParserHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle = null;
        switch (index) {
            case R.string.xml_base_info:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.xml_base_info);
                IntentUtils.intent(context, bundle, XMLBaseInfoActivity.class, false);
                break;
            case R.string.pull_parser:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.pull_parser);
                IntentUtils.intent(context, bundle, XMLParserActivity.class, false);
                break;
            case R.string.sax_parser:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.sax_parser);
                IntentUtils.intent(context, bundle, XMLParserActivity.class, false);
                break;
            case R.string.dom_parser:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, R.string.dom_parser);
                IntentUtils.intent(context, bundle, XMLParserActivity.class, false);
                break;
            default:
                break;
        }
    }
}
