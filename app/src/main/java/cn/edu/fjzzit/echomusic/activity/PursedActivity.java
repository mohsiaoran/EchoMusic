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

public class PursedActivity extends AppCompatActivity {
    private ListView pursed_listview;
    private List<Map<String,Object>> dataList_purse;
    private SimpleAdapter simp_adapter_pursed;
    private View pursed_return_btn;

    int[] mImg = new int[]{
            R.drawable.a24,
            R.drawable.a9,
            R.drawable.a10,
            R.drawable.a11,
            R.drawable.a12,
            R.drawable.a13,
            R.drawable.a14,
            R.drawable.a15,
            R.drawable.a16,
            R.drawable.a17,
            R.drawable.a18,
            R.drawable.a25
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pursed_music);
        pursed_return_btn = (View) findViewById(R.id.pursed_return_btn);
        pursed_return_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        pursed_listview = (ListView) findViewById(R.id.pursed_listview);
        dataList_purse=new ArrayList<Map<String,Object>>();
        simp_adapter_pursed=new SimpleAdapter(this, getData(),R.layout.opus_item, new String[]{"opus_img", "opus_text"}, new int[]{R.id.opus_img, R.id.opus_text});//新建适配器

        pursed_listview.setAdapter(simp_adapter_pursed);      //视图加载适配器
    }

    private List<Map<String,Object>> getData(){
        for(int i=0;i<12;i++){
            Map<String,Object>map=new HashMap<String, Object>();
            map.put("opus_img", mImg[i]);
            map.put("opus_text", "购买记录"+i);    //显示的信息
            dataList_purse.add(map);
        }
        return dataList_purse;
    }
}
