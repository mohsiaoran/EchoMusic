package cn.edu.fjzzit.echomusic.activity;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.dbtext.UserDao;

// 搜索界面
public class SearchActivity extends AppCompatActivity {
    ListView listView;
    List<String> list;
    ArrayAdapter<String> adapter;
    EditText editText;
    ImageButton return_btn;
    private String itemValue;
    String TAG="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.etSearch);
        list = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        //对editText进行文本改变监听
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //查询字符所对应的音乐
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UserDao userDao = new UserDao();
                        userDao.search(list, s.toString());
                    }
                }).start();
                adapter.notifyDataSetChanged();
            }
        });

        return_btn = (ImageButton) findViewById(R.id.return_btn);
        return_btn.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // ListView每个item点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取item值
                itemValue = (String) parent.getItemAtPosition(position);
                //通过字符串获取资源id
                Resources res = SearchActivity.this.getResources();
                int num = res.getIdentifier(itemValue, "raw", SearchActivity.this.getPackageName());
                Log.d(TAG, num+"");
                //1、准备意图
                Intent intent=new Intent("com.test.send.message");
                //2、传值
                intent.putExtra("id", num+"");//第一个参数是key键，第二个是值
                //3、发送广播
                //有序广播
                SearchActivity.this.sendBroadcast(intent);
                //关闭
                finish();
            }
        });
    }

}