package cn.edu.fjzzit.echomusic.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.adapter.MusicAdapter;


public class DialogActivity extends Dialog {
    private ListView lv;
    private String itemValue;
    final String TAG="";


    public DialogActivity(@NonNull Context context) {
        super(context);
    }

    public DialogActivity(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected DialogActivity(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_content_normal);


//        // 设置弹窗
//        Window dialogWindow = getWindow();  //得到弹框
//        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
//        lp.width = 1440;
//        lp.y = 2880;  //离部距离为0
//        lp.alpha = 0.8f;
//        dialogWindow.setAttributes(lp);
        // 获取当前Activity所在的窗体
        Window dialogWindow = getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        //设置宽
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置高
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogWindow.setBackgroundDrawableResource(android.R.color.white);
        dialogWindow.setAttributes(lp);

        // 设置适配器
        MusicAdapter musicAdapter = new MusicAdapter();
        List<String> data = musicAdapter.getData();
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, data));

        // ListView每个item点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取item值
                itemValue = (String) parent.getItemAtPosition(position);

                TextView text_top =(TextView) findViewById(R.id.text_top);
                text_top.setText("当前播放的是："+itemValue);

                //通过字符串获取资源id
                Resources res = getContext().getResources();
                int num = res.getIdentifier(itemValue, "raw", getContext().getPackageName());
                Intent intent = new Intent(getContext(), EchoActivity.class);
                intent.putExtra("id", num+"");
                getContext().startActivity(intent);
            }
        });
    }

}