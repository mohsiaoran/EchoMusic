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

public class MyfavoriteActivity  extends AppCompatActivity {
    private ListView my_favorite_listview;
    private List<Map<String,Object>> dataList_my_favorite;
    private SimpleAdapter simp_adapter_my_favorite;
    private View my_favorite_return_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_favorite);
        my_favorite_return_btn = (View) findViewById(R.id.my_favorite_return_btn);
        my_favorite_return_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        my_favorite_listview = (ListView) findViewById(R.id.my_favorite_listview);
        dataList_my_favorite=new ArrayList<Map<String,Object>>();
        simp_adapter_my_favorite=new SimpleAdapter(this, getData(),R.layout.opus_item, new String[]{"opus_img", "opus_text"}, new int[]{R.id.opus_img, R.id.opus_text});//新建适配器

        my_favorite_listview.setAdapter(simp_adapter_my_favorite);      //视图加载适配器
    }

    private List<Map<String,Object>> getData(){
        for(int i=0;i<20;i++){
            Map<String,Object>map=new HashMap<String, Object>();
            map.put("opus_text", "喜爱"+i);    //显示的信息
            dataList_my_favorite.add(map);
        }
        return dataList_my_favorite;
    }
}
