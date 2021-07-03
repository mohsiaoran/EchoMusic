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

public class MyDownloadActivity extends AppCompatActivity {
    private ListView my_download_listview;
    private List<Map<String,Object>> dataList_my_download;
    private SimpleAdapter simp_adapter_my_download;
    private View my_download_return_btn;

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
        setContentView(R.layout.my_download);
        my_download_return_btn = (View) findViewById(R.id.my_download_return_btn);
        my_download_return_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        my_download_listview = (ListView) findViewById(R.id.my_download_listview);
        dataList_my_download=new ArrayList<Map<String,Object>>();
        simp_adapter_my_download=new SimpleAdapter(this, getData(),R.layout.opus_item, new String[]{"opus_img", "opus_text"}, new int[]{R.id.opus_img, R.id.opus_text});//新建适配器

        my_download_listview.setAdapter(simp_adapter_my_download);      //视图加载适配器
    }

    private List<Map<String,Object>> getData(){
        for(int i=0;i<12;i++){
            Map<String,Object>map=new HashMap<String, Object>();
            map.put("opus_img", mImg[i]);
            map.put("opus_text", "下载"+i);    //显示的信息
            dataList_my_download.add(map);
        }
        return dataList_my_download;
    }
}
