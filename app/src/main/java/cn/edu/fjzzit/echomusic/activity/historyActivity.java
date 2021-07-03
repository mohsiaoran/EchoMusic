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

public class historyActivity extends AppCompatActivity {
    private ListView history_listview;
    private List<Map<String,Object>> dataList_history;
    private SimpleAdapter simp_adapter_history;
    private View return_btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        return_btn3 = (View) findViewById(R.id.return_btn3);
        return_btn3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        history_listview = (ListView) findViewById(R.id.pursed_listview);
        dataList_history=new ArrayList<Map<String,Object>>();
        simp_adapter_history=new SimpleAdapter(this, getData(),R.layout.tip_item, new String[]{"contentText", "timeText"}, new int[]{R.id.contentText, R.id.timeText});//新建适配器

        history_listview.setAdapter(simp_adapter_history);      //视图加载适配器
    }

    private List<Map<String,Object>> getData(){
        for(int i=0;i<20;i++){
            Map<String,Object>map=new HashMap<String, Object>();
            map.put("contentText", "历史记录"+i);    //显示的信息
            map.put("timeText","2021-7-1"); //显示的时间信息
            dataList_history.add(map);
        }
        return dataList_history;
    }

}

