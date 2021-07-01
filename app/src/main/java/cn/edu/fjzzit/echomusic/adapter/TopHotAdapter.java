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

import cn.edu.fjzzit.echomusic.entity.TopInfo;

public class TopHotAdapter extends RecyclerView.Adapter<TopHotAdapter.ViewHolder> {

    private List<TopInfo> topInfoList;
    private Context context;

    public TopHotAdapter(List<TopInfo> topInfoList, Context context) {
        this.topInfoList = topInfoList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.top_hot_rlv, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TopInfo topInfo = topInfoList.get(position);
        holder.title.setText(topInfo.getTitle());
        holder.author.setText(topInfo.getAuthor());
        if (topInfo.getContent().length() > 14) {
            String content = topInfo.getContent().substring(0, 14) + "...";
            holder.content.setText(content);
        } else {
            holder.content.setText(topInfo.getContent());
        }


//        holder.icon.setImageResource(context.getResources().getIdentifier(dailyForecast.getIcon(), "drawable", context.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return topInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView author;
        TextView content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.top_title_tv);
            author = itemView.findViewById(R.id.top_author_tv);
            content = itemView.findViewById(R.id.top_content_tv);
        }
    }
}
