package cn.edu.fjzzit.echomusic.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.fjzzit.echomusic.R;

public class WorkManagementActivity extends AppCompatActivity {
    private View return_btn2;
    private ListView work_listview;
    private List<Map<String,Object>> dataList_work;
    private SimpleAdapter simp_adapter_work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.work_collection);

        return_btn2 = (View) findViewById(R.id.return_btn2);
        return_btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        work_listview = (ListView) findViewById(R.id.work_listview);
        dataList_work=new ArrayList<Map<String,Object>>();
        simp_adapter_work=new SimpleAdapter(this, getData(),R.layout.block_item, new String[]{"textView10", "imageView4", "imageView2"}, new int[]{R.id.textView10, R.id.imageView4, R.id.imageView2});//新建适配器

        work_listview.setAdapter(simp_adapter_work);      //视图加载适配器
    }

    private List<Map<String,Object>> getData(){
        for(int i=0;i<20;i++){
            Map<String,Object>map=new HashMap<String, Object>();
            map.put("textView10", "教程"+i);    //显示的信息
            dataList_work.add(map);
        }
        return dataList_work;
    }

}
