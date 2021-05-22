package cn.edu.fjzzit.echomusic.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.entity.PostInfo;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{

    private List<PostInfo> postInfoList;
    private Context context;

    public PostAdapter(List<PostInfo> postInfoList,Context context){
        this.postInfoList = postInfoList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_rlv, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostInfo postInfo = postInfoList.get(position);
        holder.userName.setText(postInfo.getUserName());
        holder.postTime.setText(postInfo.getPostTime());
        holder.postContent.setText(postInfo.getPostContent());

//        holder.icon.setImageResource(context.getResources().getIdentifier(dailyForecast.getIcon(), "drawable", context.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return postInfoList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView userName;
        TextView postTime;
        TextView postContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.social_username);
            postTime = itemView.findViewById(R.id.social_post_time);
            postContent = itemView.findViewById(R.id.post_content);
        }
    }
}