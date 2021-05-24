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
import cn.edu.fjzzit.echomusic.entity.ChosenInfo;
import cn.edu.fjzzit.echomusic.entity.PostInfo;

public class ChosenAdapter extends RecyclerView.Adapter<ChosenAdapter.ViewHolder>{

    private List<ChosenInfo> chosenInfoList;
    private Context context;

    public ChosenAdapter(List<ChosenInfo> chosenInfoList, Context context){
        this.chosenInfoList = chosenInfoList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.chosen_rlv, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChosenInfo chosenInfo = chosenInfoList.get(position);
        holder.title.setText(chosenInfo.getTitle());
        holder.author.setText(chosenInfo.getAuthor());
        if(chosenInfo.getContent().length()>14){
            String content=chosenInfo.getContent().substring(0,14)+"...";
            holder.content.setText(content);
        }else {
            holder.content.setText(chosenInfo.getContent());
        }



//        holder.icon.setImageResource(context.getResources().getIdentifier(dailyForecast.getIcon(), "drawable", context.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return chosenInfoList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView author;
        TextView content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.chosen_title_tv);
            author = itemView.findViewById(R.id.chosen_author_tv);
            content = itemView.findViewById(R.id.chosen_content_tv);
        }
    }
}