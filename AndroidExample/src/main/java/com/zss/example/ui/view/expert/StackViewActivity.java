package com.zss.example.ui.view.expert;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.StackView;
import android.widget.TextView;
import android.widget.Toast;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;

/**
 * 描述：StackViewActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class StackViewActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private StackView stackView;
    private Button btn_forward;
    private Button btn_next;
    private int colors[] = {R.drawable.style_character_sketch, R.drawable.style_full_view_hand_painted,
            R.drawable.style_elaboration_hand_painted, R.drawable.style_elaborationgame_character};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);

        btn_forward = (Button) findViewById(R.id.btn_forward);
        btn_forward.setOnClickListener(this);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);

        stackView = (StackView) findViewById(R.id.stackView);
        stackView.setAdapter(new StackViewAdapter(this, colors));
        stackView.setOnItemClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_forward:
                stackView.showPrevious();
                break;
            case R.id.btn_next:
                stackView.showNext();
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(StackViewActivity.this, i + "", Toast.LENGTH_SHORT).show();
        stackView.setDisplayedChild(i);
    }
}

class StackViewAdapter extends BaseAdapter {
    private Context context;
    private int[] images;

    public StackViewAdapter(Context context, int images[]) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.adapter_stack_view_item, null);
            holder.imageView = (ImageView) view.findViewById(R.id.imageView);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.imageView.setImageResource(images[i]);
        return view;
    }

    static class ViewHolder {
        ImageView imageView;
    }
}
