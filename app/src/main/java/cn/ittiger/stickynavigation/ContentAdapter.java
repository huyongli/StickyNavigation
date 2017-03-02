package cn.ittiger.stickynavigation;

import cn.ittiger.recyclerview.CommonRecyclerViewAdapter;
import cn.ittiger.recyclerview.CommonViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ylhu on 17-2-23.
 */
public class ContentAdapter extends CommonRecyclerViewAdapter<String> {
    private Context mContext;

    public ContentAdapter(Context context, List<String> list) {

        super(list);
        mContext = context;
    }

    @Override
    public CommonViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(CommonViewHolder holder, int position, String item) {

        ContentViewHolder viewHolder = (ContentViewHolder) holder;
        viewHolder.mTextView.setText(mList.get(position));
    }

    class ContentViewHolder extends CommonViewHolder {
        TextView mTextView;
        public ContentViewHolder(View itemView) {

            super(itemView);
            mTextView = (TextView) itemView;
        }
    }
}
