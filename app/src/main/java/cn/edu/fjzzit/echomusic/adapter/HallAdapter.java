package cn.edu.fjzzit.echomusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.entity.HallInfo;

public class HallAdapter extends RecyclerView.Adapter<HallAdapter.ViewHolder>{

    private List<HallInfo> hallInfoList;
    private Context context;

    public HallAdapter(List<HallInfo> hallInfoList, Context context){
        this.hallInfoList = hallInfoList;
        this.context = context;
    }

    @NonNull
    @Override
    public HallAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.hall_rly, parent, false);
        HallAdapter.ViewHolder holder = new HallAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HallInfo hallInfo = hallInfoList.get(position);
        holder.userName.setText(hallInfo.getUserName());
        holder.postTime.setText(hallInfo.getPostTime());
        holder.author.setText(hallInfo.getAuthor());
        holder.title.setText(hallInfo.getTitle());
        holder.image.setImageResource(hallInfo.getImage());
        if(hallInfo.getContent().length()>14){
            String content=hallInfo.getContent().substring(0,14)+"...";
            holder.content.setText(content);
        }else {
            holder.content.setText(hallInfo.getContent());
        }



//        holder.icon.setImageResource(context.getResources().getIdentifier(dailyForecast.getIcon(), "drawable", context.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return hallInfoList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView userName;
        TextView postTime;
        TextView state;
        TextView author;
        TextView title;
        TextView content;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.hall_username);
            postTime = itemView.findViewById(R.id.hall_post_time);
            author = itemView.findViewById(R.id.hall_author_tv);
            title = itemView.findViewById(R.id.hall_title_tv);
            content = itemView.findViewById(R.id.hall_content_tv);
            image =itemView.findViewById(R.id.hall_img_iv);
        }
    }
}
