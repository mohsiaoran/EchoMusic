package cn.edu.fjzzit.echomusic.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.fjzzit.echomusic.R;

public class SongBookActivity extends AppCompatActivity {
    private ListView song_book_listview;
    private List<Map<String,Object>> dataList_song_book;
    private SimpleAdapter simp_adapter_song_book;
    private View song_book_return_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_book);
        song_book_return_btn = (View) findViewById(R.id.song_book_return_btn);
        song_book_return_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        song_book_listview = (ListView) findViewById(R.id.song_book_listview);
        dataList_song_book=new ArrayList<Map<String,Object>>();
        simp_adapter_song_book=new SimpleAdapter(this, getData(),R.layout.opus_item, new String[]{"opus_img", "opus_text"}, new int[]{R.id.opus_img, R.id.opus_text});//新建适配器

        song_book_listview.setAdapter(simp_adapter_song_book);      //视图加载适配器
    }

    private List<Map<String,Object>> getData(){
        for(int i=0;i<20;i++){
            Map<String,Object>map=new HashMap<String, Object>();
            map.put("opus_text", "乐曲"+i);    //显示的信息
            dataList_song_book.add(map);
        }
        return dataList_song_book;
    }
}
