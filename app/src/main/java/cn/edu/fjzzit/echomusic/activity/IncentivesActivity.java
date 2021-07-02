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

public class IncentivesActivity extends AppCompatActivity {
    private ListView incetives_listview;
    private List<Map<String,Object>> dataList_incetives;
    private SimpleAdapter simp_adapter_incetives;
    private View back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.incentives);
        back_btn = (View) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        incetives_listview = (ListView) findViewById(R.id.incetives_listview);
        dataList_incetives=new ArrayList<Map<String,Object>>();
        simp_adapter_incetives=new SimpleAdapter(this, getData(),R.layout.tip_item, new String[]{"contentText", "timeText"}, new int[]{R.id.contentText, R.id.timeText});//新建适配器

        incetives_listview.setAdapter(simp_adapter_incetives);      //视图加载适配器
    }

    private List<Map<String,Object>> getData(){
        for(int i=0;i<20;i++){
            Map<String,Object>map=new HashMap<String, Object>();
            map.put("contentText", "消息"+i);    //显示的信息
            map.put("timeText","2021-7-1"); //显示的时间信息
            dataList_incetives.add(map);
        }
        return dataList_incetives;
    }


}
