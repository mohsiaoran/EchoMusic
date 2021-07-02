package cn.edu.fjzzit.echomusic.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.adapter.ChosenAdapter;
import cn.edu.fjzzit.echomusic.adapter.LocalMusicAdapter;
import cn.edu.fjzzit.echomusic.adapter.MusicAdapter;
import cn.edu.fjzzit.echomusic.entity.MusicInfo;
import cn.edu.fjzzit.echomusic.utils.MusicUtils;

//本地音乐activity
public class LocalMusicActivity extends AppCompatActivity {
    private Button scanMusicBtn;
    private RecyclerView musicListLRlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_music);

        scanMusicBtn = findViewById(R.id.btn_scan_music);
        musicListLRlv = findViewById(R.id.rlv_local_music_list);

        SharedPreferences sp =getSharedPreferences("MusicList", getApplicationContext().MODE_PRIVATE);
        //Log.d("test:","start");
        String data = null;
        try {
            data = sp.getString("musicData", "");
            //Log.d("test:",String.valueOf(data));
            Gson gson = new Gson();
            Type listType = new TypeToken<List<MusicInfo>>() {}.getType();
            List<MusicInfo> musicList = gson.fromJson(data, listType);

            //适配器加载音乐列表
            if(musicList.size()!=0){
                RecyclerView.LayoutManager musicListLayoutManager = new LinearLayoutManager(getApplicationContext());
                musicListLRlv.setLayoutManager(musicListLayoutManager);
                LocalMusicAdapter musicAdapter = new LocalMusicAdapter(musicList, getApplicationContext());
                musicListLRlv.setAdapter(musicAdapter);
            }else {
                Toast.makeText(getBaseContext(),"未找到音乐",Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Toast.makeText(getBaseContext(),"未扫描音乐",Toast.LENGTH_LONG).show();
        }






        scanMusicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<MusicInfo> musicInfoList = MusicUtils.getMusicData(getBaseContext());
                Log.d("musicuntis:",String.valueOf(musicInfoList.size()));
                Gson gson = new Gson();
                String musicData = gson.toJson(musicInfoList);

                //实例化SharedPreferences对象,参数1是存储文件的名称，参数2是文件的打开方式，当文件不存在时，直接创建，如果存在，则直接使用
                SharedPreferences sp =getSharedPreferences("MusicList", getApplicationContext().MODE_PRIVATE);
                //实例化SharedPreferences.Editor对象
                SharedPreferences.Editor editor =sp.edit();

                //用putString的方法保存数据
                editor.putString("musicData", musicData);

                //提交数据
                editor.commit();

                finish();
                startActivity(getIntent());
            }
        });

    }



}