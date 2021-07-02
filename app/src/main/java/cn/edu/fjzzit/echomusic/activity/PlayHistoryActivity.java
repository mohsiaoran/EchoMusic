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

public class PlayHistoryActivity extends AppCompatActivity {
    private ListView play_history_listview;
    private List<Map<String,Object>> dataList_play_history;
    private SimpleAdapter simp_adapter_play_history;
    private View play_history_return_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_history);
        play_history_return_btn = (View) findViewById(R.id.play_history_return_btn);
        play_history_return_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        play_history_listview = (ListView) findViewById(R.id.play_history_listview);
        dataList_play_history=new ArrayList<Map<String,Object>>();
        simp_adapter_play_history=new SimpleAdapter(this, getData(),R.layout.opus_item, new String[]{"opus_img", "opus_text"}, new int[]{R.id.opus_img, R.id.opus_text});//新建适配器

        play_history_listview.setAdapter(simp_adapter_play_history);      //视图加载适配器
    }

    private List<Map<String,Object>> getData(){
        for(int i=0;i<20;i++){
            Map<String,Object>map=new HashMap<String, Object>();
            map.put("opus_text", "历史"+i);    //显示的信息
            dataList_play_history.add(map);
        }
        return dataList_play_history;
    }
}
