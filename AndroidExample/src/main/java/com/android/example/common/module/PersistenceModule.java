package com.android.example.common.module;

import android.content.Context;

import com.android.example.common.Constance;
import com.android.example.helper.persistence_helper.FilePersistenceHelper;
import com.android.example.helper.persistence_helper.SQLitePersistenceHelper;

import java.util.List;

/**
 * 描述：PersistenceModule
 * Created by Administrator on 2016/3/31 0031.
 */
public class PersistenceModule extends BaseModule {
    private Context context;
    private List<Integer> list;

    public PersistenceModule(Context context, List<Integer> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public void myModule(int type, int position) {
        dataPersistenceModule(type, position);
    }

    /**
     * 方法描述:数据持久化的goNext
     *
     * @param type:类型
     * @param position:位置
     */
    private void dataPersistenceModule(int type, int position) {
        switch (type) {
            case Constance.SQLITE:
                SQLitePersistenceHelper.goNext(context, list.get(position));
                break;
            case Constance.FILE:
                FilePersistenceHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }
}
