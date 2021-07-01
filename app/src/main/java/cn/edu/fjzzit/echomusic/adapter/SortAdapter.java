package cn.edu.fjzzit.echomusic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.entity.ListInfo;
import cn.edu.fjzzit.echomusic.entity.SortInfo;

public class SortAdapter extends RecyclerView.Adapter<SortAdapter.ViewHolder> {

    private List<SortInfo> mSortList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView sortImage;
        TextView sortTitle;

        public ViewHolder(View view) {
            super(view);
            sortImage = (ImageView) view.findViewById(R.id.sort_img_iv);
            sortTitle = (TextView) view.findViewById(R.id.sort_title_tv);
        }

    }

    public SortAdapter(List<SortInfo> sortInfos) {
        mSortList = sortInfos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sort_rly, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        SortInfo sortInfo = mSortList.get(position);
        holder.sortImage.setImageResource(sortInfo.getSortImage());
        holder.sortTitle.setText(sortInfo.getSortTitle());
    }

    @Override
    public int getItemCount() {
        return mSortList.size();
    }
}