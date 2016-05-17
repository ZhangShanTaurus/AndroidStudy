package com.zss.example.ui.view.container;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import com.zss.example.R;
import com.zss.example.common.Constance;
import com.zss.example.main.BaseActivity;
import com.zss.example.main.MyBaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：GalleryActivity
 * Created by Administrator on 2016/1/21 0021.
 */
public class GalleryActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private ImageView iv_bg;
    private Gallery gallery;
    private GalleryAdapter adapter;
    private List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_layout);
        initView();
        initData();
    }

    @Override
    public void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_bg = (ImageView) findViewById(R.id.iv_bg);
        gallery = (Gallery) findViewById(R.id.gallery);
        gallery.setOnItemClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent().getExtras() != null) {
            tv_title.setText(getIntent().getExtras().getInt(Constance.TITLE));
        }

        list = new ArrayList<>();
        list.add(R.drawable.style_character_sketch);
        list.add(R.drawable.style_color_hand_painted);
        list.add(R.drawable.style_elaboration_hand_painted);
        list.add(R.drawable.style_elaborationgame_character);
        list.add(R.drawable.style_full_view_hand_painted);
        list.add(R.drawable.style_game_character);
        list.add(R.drawable.style_japanese_q);
        list.add(R.drawable.style_modern_q);

        adapter = new GalleryAdapter(this, list);
        gallery.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        iv_bg.setImageResource(list.get(i % list.size()));
    }
}


/**
 * 适配器
 */
class GalleryAdapter extends MyBaseAdapter {
    private Context context;
    private List<Integer> list;

    public GalleryAdapter(Context context, List list) {
        super(list);
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.adapter_gallery_item_layout, null);
            holder.imageView = (ImageView) view.findViewById(R.id.imageView);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.imageView.setImageResource(list.get(i % list.size()));
        return view;
    }

    static class ViewHolder {
        ImageView imageView;
    }
}