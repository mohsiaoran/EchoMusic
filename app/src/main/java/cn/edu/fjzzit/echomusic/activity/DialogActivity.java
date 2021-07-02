package cn.edu.fjzzit.echomusic.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.adapter.LocalMusicAdapter;
import cn.edu.fjzzit.echomusic.adapter.MusicAdapter;
import cn.edu.fjzzit.echomusic.adapter.MusicListAdapter;
import cn.edu.fjzzit.echomusic.entity.MusicInfo;


public class DialogActivity extends Dialog {
    private RecyclerView musicListRlv;
    private String itemValue;
    EchoActivity myReceiver;
    int RESULT_OK = -1;

    final String TAG="";

    public DialogActivity(@NonNull Context context) {
        super(context);
    }

    public DialogActivity(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected DialogActivity(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_content_normal);


        // 获取当前Activity所在的窗体
        Window dialogWindow = getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        //设置宽
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置高
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //设置背景颜色
        dialogWindow.setBackgroundDrawableResource(android.R.color.white);
        dialogWindow.setAttributes(lp);

        musicListRlv = findViewById(R.id.music_play_list);
        // 设置适配器
        List<MusicInfo> musicInfoList = EchoActivity.musicService.musicInfoList;
        RecyclerView.LayoutManager musicListLayoutManager = new LinearLayoutManager(getContext());
        musicListRlv.setLayoutManager(musicListLayoutManager);
        MusicListAdapter musicAdapter = new MusicListAdapter(musicInfoList, getContext());
        musicListRlv.setAdapter(musicAdapter);
//        MusicAdapter musicAdapter = new MusicAdapter();
//        List<String> data = musicAdapter.getData();
//        lv = (ListView) findViewById(R.id.music_play_list);
//        lv.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, data));

        // ListView每个item点击事件

    }

}
