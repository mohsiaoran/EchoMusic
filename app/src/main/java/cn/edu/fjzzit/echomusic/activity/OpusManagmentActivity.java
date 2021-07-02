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

public class OpusManagmentActivity extends AppCompatActivity {
    private ListView opus_listview;
    private List<Map<String,Object>> dataList_opus;
    private SimpleAdapter simp_adapter_opus;
    private View return_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opus);

        return_btn2 = (View) findViewById(R.id.return_btn2);
        return_btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        opus_listview = (ListView) findViewById(R.id.opus_listview);
        dataList_opus=new ArrayList<Map<String,Object>>();
        simp_adapter_opus=new SimpleAdapter(this, getData(),R.layout.opus_item, new String[]{"opus_img", "opus_text"}, new int[]{R.id.opus_img, R.id.opus_text});//新建适配器

        opus_listview.setAdapter(simp_adapter_opus);      //视图加载适配器
    }

    private List<Map<String,Object>> getData(){
        for(int i=0;i<20;i++){
            Map<String,Object>map=new HashMap<String, Object>();
            map.put("opus_text", "我的作品"+i);    //显示的信息
            dataList_opus.add(map);
        }
        return dataList_opus;
    }

}

