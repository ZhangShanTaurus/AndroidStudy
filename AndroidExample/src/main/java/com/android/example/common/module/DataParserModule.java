package com.android.example.common.module;

import android.content.Context;

import com.android.example.common.Constance;
import com.android.example.helper.data_parser_helper.XMLParserHelper;

import java.util.List;

/**
 * 描述：DataParserModule
 * Created by Administrator on 2016/3/31 0031.
 */
public class DataParserModule extends BaseModule {
    private Context context;
    private List<Integer> list;

    public DataParserModule(Context context, List<Integer> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void myModule(int type, int position) {
        xmlParserModule(type, position);
    }

    /**
     * 方法描述:xml解析模块
     *
     * @param type:类型
     * @param position:位置
     */
    private void xmlParserModule(int type, int position) {
        switch (type) {
            case Constance.DATA_XML_PARSER:
                XMLParserHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }
}
