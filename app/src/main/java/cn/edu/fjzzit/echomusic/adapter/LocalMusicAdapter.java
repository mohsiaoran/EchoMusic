package cn.edu.fjzzit.echomusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.entity.ChosenInfo;
import cn.edu.fjzzit.echomusic.entity.MusicInfo;
import cn.edu.fjzzit.echomusic.service.MusicService;

public class LocalMusicAdapter extends RecyclerView.Adapter<LocalMusicAdapter.ViewHolder>{

    private List<MusicInfo> musicInfoList;
    private Context context;

    public LocalMusicAdapter(List<MusicInfo> musicInfoList, Context context){
        this.musicInfoList = musicInfoList;
        this.context = context;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.music_list_info, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        if (musicInfoList.size()==0){
            holder.title.setText("未找到音乐");
        }else{
            MusicInfo musicInfo = musicInfoList.get(position);
            holder.num.setText(String.valueOf(position+1));
            holder.title.setText(musicInfo.getTitle());
            holder.author.setText(musicInfo.getArtist());}

    }

    @Override
    public int getItemCount() {
        return musicInfoList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView num;
        TextView title;
        TextView author;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            num = itemView.findViewById(R.id.music_num);
            title = itemView.findViewById(R.id.musiclist_music_title);
            author = itemView.findViewById(R.id.musiclist_music_author);
        }
    }
}
