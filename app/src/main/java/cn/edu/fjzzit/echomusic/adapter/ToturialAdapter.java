package cn.edu.fjzzit.echomusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.entity.ToturialInfo;

public class ToturialAdapter extends RecyclerView.Adapter<ToturialAdapter.ViewHolder>{

    private List<ToturialInfo> toturialInfoList;
    private Context context;

    public ToturialAdapter(List<ToturialInfo> toturialInfoList,Context context){
        this.toturialInfoList=toturialInfoList;
        this.context=context;
    }

    @NonNull
    @Override
    public ToturialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.toturial_rlv, parent, false);
        ToturialAdapter.ViewHolder holder = new ToturialAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ToturialAdapter.ViewHolder holder, int position) {
        ToturialInfo toturialInfo = toturialInfoList.get(position);
        holder.title.setText(toturialInfo.getTitle());
        holder.good.setText(toturialInfo.getGood());
    }

    @Override
    public int getItemCount() {
        return toturialInfoList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView good;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.toturial_title_tv);
            good = itemView.findViewById(R.id.toturial_good_tv);
        }
    }
}
