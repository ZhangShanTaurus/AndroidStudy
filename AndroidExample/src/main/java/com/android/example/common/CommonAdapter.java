package com.android.example.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.example.R;
import com.android.example.common.module.AdaptiveModule;
import com.android.example.common.module.BaseKnowledgeModule;
import com.android.example.common.module.CommunicationModule;
import com.android.example.common.module.DataParserModule;
import com.android.example.common.module.DebugModule;
import com.android.example.common.module.ExtendModule;
import com.android.example.common.module.MultiThreadModule;
import com.android.example.common.module.NDKModule;
import com.android.example.common.module.OtherModule;
import com.android.example.common.module.PerformanceModule;
import com.android.example.common.module.PersistenceModule;
import com.android.example.common.module.PhoneFunctionModule;
import com.android.example.common.module.SafeModule;
import com.android.example.common.module.TestModule;
import com.android.example.common.module.UIModule;
import com.android.example.helper.AdaptiveHelper;
import com.android.example.helper.BaseKnowledgeHelper;
import com.android.example.helper.CommunicationHelper;
import com.android.example.helper.DataParserHelper;
import com.android.example.helper.DebugHelper;
import com.android.example.helper.ExtendHelper;
import com.android.example.helper.MultiThreadHelper;
import com.android.example.helper.NDKHelper;
import com.android.example.helper.OtherHelper;
import com.android.example.helper.PerformanceHelper;
import com.android.example.helper.PersistenceHelper;
import com.android.example.helper.PhoneFunctionHelper;
import com.android.example.helper.SafeHelper;
import com.android.example.helper.TestHelper;
import com.android.example.helper.UIHelper;
import com.android.example.main.MyBaseAdapter;

import java.util.List;

/**
 * 描述：CommonAdapter
 * Created by Administrator on 2016/1/13 0013.
 */
public class CommonAdapter extends MyBaseAdapter {
    private List<Integer> list;
    private Context context;
    private int type;

    private BaseKnowledgeModule baseKnowledgeModule;
    private UIModule uiModule;
    private MultiThreadModule multiThreadModule;
    private CommunicationModule communicationModule;
    private DataParserModule dataParserModule;
    private PersistenceModule persistenceModule;
    private PerformanceModule performanceModule;
    private PhoneFunctionModule phoneFunctionModule;
    private DebugModule debugModule;
    private AdaptiveModule adaptiveModule;
    private TestModule testModule;
    private SafeModule safeModule;
    private NDKModule ndkModule;
    private ExtendModule extendModule;
    private OtherModule otherModule;

    {

    }

    public CommonAdapter(Context context, MyData myData) {
        super(myData.getList());
        this.context = context;
        this.list = myData.getList();
        this.type = myData.getType();

        baseKnowledgeModule = new BaseKnowledgeModule(context, list);
        uiModule = new UIModule(context, list);
        multiThreadModule = new MultiThreadModule(context, list);
        communicationModule = new CommunicationModule(context, list);
        dataParserModule = new DataParserModule(context, list);
        persistenceModule = new PersistenceModule(context, list);
        performanceModule = new PerformanceModule(context, list);
        phoneFunctionModule = new PhoneFunctionModule(context, list);
        debugModule = new DebugModule(context, list);
        adaptiveModule = new AdaptiveModule(context, list);
        testModule = new TestModule(context, list);
        safeModule = new SafeModule(context, list);
        ndkModule = new NDKModule(context, list);
        extendModule = new ExtendModule(context, list);
        otherModule = new OtherModule(context, list);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        ClickListener clickListener = null;
        if (view == null) {
            holder = new ViewHolder();
            clickListener = new ClickListener();
            view = LayoutInflater.from(context).inflate(R.layout.commen_adapter_item_layout, null);
            holder.button = (Button) view.findViewById(R.id.button);
            view.setTag(holder);
            view.setTag(R.id.button, clickListener);
        } else {
            holder = (ViewHolder) view.getTag();
            clickListener = (ClickListener) view.getTag(R.id.button);
        }

        holder.button.setText(list.get(i));
        clickListener.setPosition(i);
        holder.button.setOnClickListener(clickListener);
        return view;
    }

    static class ViewHolder {
        private Button button;
    }


    class ClickListener implements View.OnClickListener {
        private int position;

        public void setPosition(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            everyModule(type, position);
            baseKnowledgeModule.myModule(type, position);
            uiModule.myModule(type, position);
            multiThreadModule.myModule(type, position);
            communicationModule.myModule(type, position);
            dataParserModule.myModule(type, position);
            persistenceModule.myModule(type, position);
            performanceModule.myModule(type, position);
            phoneFunctionModule.myModule(type, position);
            debugModule.myModule(type, position);
            adaptiveModule.myModule(type, position);
            testModule.myModule(type, position);
            safeModule.myModule(type, position);
            ndkModule.myModule(type, position);
            extendModule.myModule(type, position);
            otherModule.myModule(type, position);
        }
    }

    /**
     * 方法描述:各个大的模块的goNext
     *
     * @param type:类型
     * @param position:位置
     */
    public void everyModule(int type, int position) {
        switch (type) {
            case Constance.BASE_KNOWLEDGE:
                BaseKnowledgeHelper.goNext(context, list.get(position));
                break;
            case Constance.UI:
                UIHelper.goNext(context, list.get(position));
                break;
            case Constance.MULTI_THREAD:
                MultiThreadHelper.goNext(context, list.get(position));
                break;
            case Constance.COMMUNICATION:
                CommunicationHelper.goNext(context, list.get(position));
                break;
            case Constance.DATA_PARSER:
                DataParserHelper.goNext(context, list.get(position));
                break;
            case Constance.PERSISTENCE:
                PersistenceHelper.goNext(context, list.get(position));
                break;
            case Constance.PERFORMANCE:
                PerformanceHelper.goNext(context, list.get(position));
                break;
            case Constance.DEBUG:
                DebugHelper.goNext(context, list.get(position));
                break;
            case Constance.ADAPTIVE:
                AdaptiveHelper.goNext(context, list.get(position));
                break;
            case Constance.TEST:
                TestHelper.goNext(context, list.get(position));
                break;
            case Constance.SAFE:
                SafeHelper.goNext(context, list.get(position));
                break;
            case Constance.NDK:
                NDKHelper.goNext(context, list.get(position));
                break;
            case Constance.PHONE_FUNCTION:
                PhoneFunctionHelper.goNext(context, list.get(position));
                break;
            case Constance.EXTEND:
                ExtendHelper.goNext(context, list.get(position));
                break;
            case Constance.OTHER:
                OtherHelper.goNext(context, list.get(position));
                break;
            default:
                break;
        }
    }
}
