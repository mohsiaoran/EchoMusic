package cn.edu.fjzzit.echomusic.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.fjzzit.echomusic.R;


public class MessageActivity extends AppCompatActivity{
    private ListView official_listview;
    private ListView my_listview;
    private List<Map<String,Object>> dataList_offcail;
    private List<Map<String,Object>> dataList_my;
    private SimpleAdapter simp_adapter_offcail;
    private SimpleAdapter simp_adapter_my;
    private ImageView return_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);

        return_btn=(ImageView) findViewById(R.id.iv_back);
        return_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        official_listview=(ListView) findViewById(R.id.official_listview);
        dataList_offcail=new ArrayList<Map<String,Object>>();
        my_listview=(ListView) findViewById(R.id.my_listview);
        dataList_my=new ArrayList<Map<String,Object>>();

        simp_adapter_offcail=new SimpleAdapter(this, getData(),R.layout.message_item, new String[]{"ivPic","tvText"}, new int[]{R.id.ivPic,R.id.tvtext});//新建适配器
        simp_adapter_my=new SimpleAdapter(this, getMyData(),R.layout.message_item, new String[]{"ivPic","tvText"}, new int[]{R.id.ivPic,R.id.tvtext});//新建适配器

        official_listview.setAdapter(simp_adapter_offcail);      //视图加载适配器
        my_listview.setAdapter(simp_adapter_my);      //视图加载适配器

    }


    private List<Map<String,Object>> getData(){
        for(int i=0;i<20;i++){
            Map<String,Object>map=new HashMap<String, Object>();
            map.put("ivPic",R.drawable.user_img);    //显示的图片信息
            map.put("tvText","官方消息"+i);                  //显示的文字信息
            dataList_offcail.add(map);
        }
        return dataList_offcail;
    }

    private List<Map<String,Object>> getMyData(){
        for(int i=0;i<20;i++){
            Map<String,Object>map=new HashMap<String, Object>();
            map.put("ivPic",R.drawable.user_img);    //显示的图片信息
            map.put("tvText","我的消息"+i);                  //显示的文字信息
            dataList_my.add(map);
        }
        return dataList_my;
    }


}
