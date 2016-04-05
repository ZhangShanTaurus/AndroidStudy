package com.android.example.ui.view.container.recycler_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.example.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：RecyclerViewAdapter
 * Created by Administrator on 2016/1/27 0027.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private int type;
    public static final int LINEAR = 0;
    public static final int GRID = 1;
    public static final int FALLS = 2;

    private Context context;
    private List<String> list;
    private List<Integer> mHeights;

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public RecyclerViewAdapter(Context context, List<String> list, int type) {
        this.context = context;
        this.list = list;
        this.type = type;

        mHeights = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (type) {
            case LINEAR:
                view = LayoutInflater.from(context).inflate(R.layout.adapter_recycler_view_linear_layout, parent, false);
                break;
            case GRID:
                view = LayoutInflater.from(context).inflate(R.layout.adapter_recycler_view_grid_layout, parent, false);
                break;
            case FALLS:
                view = LayoutInflater.from(context).inflate(R.layout.adapter_recycler_view_falls_layout, parent, false);
                break;
            default:
                break;
        }
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if (type == FALLS) {
            ViewGroup.LayoutParams lp = holder.ll_falls.getLayoutParams();
            lp.height = mHeights.get(position);
            holder.ll_falls.setLayoutParams(lp);
        }

        //如果设置了回调，则设置点击事件
        if (onItemClickListener != null) {
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.textView, pos);
                }
            });

            holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(holder.textView, pos);
                    removeData(pos);
                    return false;
                }
            });
        }
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(int position) {
        list.add(position, "insert");
        mHeights.add(100 + (int) Math.random() * 300);
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        LinearLayout ll_falls;

        public MyViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
            ll_falls = (LinearLayout) view.findViewById(R.id.ll_falls);
        }
    }
}
