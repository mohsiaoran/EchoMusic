package cn.edu.fjzzit.echomusic.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import cn.edu.fjzzit.echomusic.R;

public class EchoActivity extends AppCompatActivity{

    private LinearLayout homePageBtn,creationBtn,socialBtn,myInfoBtn;
    private ImageView homePageIcon,creationIcon,socialIcon,myInfoIcon;
    private TextView homePageTxt,creationTxt,socialTxt,myInfoTxt;
    private ViewPager2 vp;
    private TabLayout nav;
    private List<Fragment> fragmentList = new ArrayList<>();
    private int[] titleList = new int[]{R.string.find,R.string.creation,R.string.social,R.string.my_info};
    private int[] iconList = new int[]{R.drawable.tab_icon_home_page,R.drawable.tab_icon_creation,R.drawable.tab_icon_social,R.drawable.tab_icon_my_info};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echo);

        init();
        vp.setCurrentItem(0,false);
    }

    private void init() {
        fragmentList.add(new HomePageFragment());
        fragmentList.add(new CreationFragment());
        fragmentList.add(new SocialFragment());
        fragmentList.add(new MyInfoFragment());

        vp = findViewById(R.id.main_viewpager);               //获得ViewPager2控件

        nav = findViewById(R.id.tab_nav);
        //设置预加载的Fragment页面数量，可防止流式布局StaggeredGrid数组越界错误。
        vp.setOffscreenPageLimit(fragmentList.size() - 1);                                                                                                                        //设置适配器
        FragmentStateAdapter adapter = new FragmentStateAdapter(EchoActivity.this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getItemCount() {
                return fragmentList.size();
            }
        };

        vp.setAdapter(adapter);                     //把适配器添加给ViewPager2

        new TabLayoutMediator(nav, vp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titleList[position]);
                tab.setIcon(iconList[position]);
            }
        }).attach();
    }
}