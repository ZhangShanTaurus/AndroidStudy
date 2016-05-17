package com.zss.example.helper.data_parser_helper;

import android.content.Context;
import android.os.Bundle;

import com.zss.example.common.Constance;
import com.zss.example.data_parser.xml.XMLParserActivity;
import com.zss.example.data_parser.xml.XMLBaseInfoActivity;
import com.zss.example.utils.IntentUtils;

/**
 * 描述：XMLParserHelper
 * Created by Administrator on 2016/1/14 0014.
 */
public class XMLParserHelper {

    public static void goNext(Context context, int index) {
        Bundle bundle = null;
        switch (index) {
            case com.zss.example.R.string.xml_base_info:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.xml_base_info);
                IntentUtils.intent(context, bundle, XMLBaseInfoActivity.class, false);
                break;
            case com.zss.example.R.string.pull_parser:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.pull_parser);
                IntentUtils.intent(context, bundle, XMLParserActivity.class, false);
                break;
            case com.zss.example.R.string.sax_parser:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.sax_parser);
                IntentUtils.intent(context, bundle, XMLParserActivity.class, false);
                break;
            case com.zss.example.R.string.dom_parser:
                bundle = new Bundle();
                bundle.putInt(Constance.TITLE, com.zss.example.R.string.dom_parser);
                IntentUtils.intent(context, bundle, XMLParserActivity.class, false);
                break;
            default:
                break;
        }
    }
}
