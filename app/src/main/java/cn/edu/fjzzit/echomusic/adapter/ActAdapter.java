package cn.edu.fjzzit.echomusic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.entity.ActInfo;


public class ActAdapter extends RecyclerView.Adapter<ActAdapter.ViewHolder> {

    private List<ActInfo> mActList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView actImage;

        public ViewHolder(View view) {
            super(view);
            actImage = (ImageView) view.findViewById(R.id.act_img_iv);
        }

    }

    public ActAdapter(List<ActInfo> actInfos) {
        mActList = actInfos;
    }

    @Override
    public ActAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.act_rlv, parent, false);
        ActAdapter.ViewHolder holder = new ActAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ActAdapter.ViewHolder holder, int position) {

        ActInfo actInfo = mActList.get(position);
        holder.actImage.setImageResource(actInfo.getActImage());
    }

    @Override
    public int getItemCount() {
        return mActList.size();
    }
}
