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

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListInfo> mList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView listImage;
        TextView listTitle;

        public ViewHolder(View view) {
            super(view);
            listImage = (ImageView) view.findViewById(R.id.list_img_iv);
            listTitle = (TextView) view.findViewById(R.id.list_title_tv);
        }

    }

    public ListAdapter(List<ListInfo> listInfos) {
        mList = listInfos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_rlv, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ListInfo listInfo = mList.get(position);
        holder.listImage.setImageResource(listInfo.getListImage());
        holder.listTitle.setText(listInfo.getListTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}