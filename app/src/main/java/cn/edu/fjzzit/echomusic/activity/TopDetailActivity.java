package cn.edu.fjzzit.echomusic.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.adapter.TopAdapter;

//排行榜的VP2
public class TopDetailActivity extends AppCompatActivity {
    private ViewPager2 vp;
    private TabLayout nav;
    private Button returnBtn;
    List<Fragment> fragmentList = new ArrayList<>();
    //标题
    List<String> titleList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_top);
        vp = findViewById(R.id.top_vp);//获得ViewPager2控件
        nav = findViewById(R.id.top_nav);
        returnBtn = findViewById(R.id.return_btn);

        titleList.add("热度榜");
        titleList.add("新歌榜");
        titleList.add("下载榜");
        titleList.add("历史榜");

        //添加Fragment进去    没有分详细榜单
        fragmentList.add(new TopDetailyFragment());
        fragmentList.add(new TopDetailyFragment());
        fragmentList.add(new TopDetailyFragment());
        fragmentList.add(new TopDetailyFragment());

        //实例化适配器
        TopAdapter topAdapter=new TopAdapter(getSupportFragmentManager(),getLifecycle(),fragmentList);
        //设置适配器
        vp.setAdapter(topAdapter);
        //TabLayout和Viewpager2进行关联
        new TabLayoutMediator(nav, vp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titleList.get(position));
            }
        }).attach();

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(TopDetailActivity.this, EchoActivity.class);
                TopDetailActivity.this.startActivity(intent);
               // finish();
            }
        });

    }
}
