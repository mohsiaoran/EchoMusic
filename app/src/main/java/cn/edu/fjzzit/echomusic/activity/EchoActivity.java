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
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import cn.edu.fjzzit.echomusic.R;

public class EchoActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout homePageBtn,creationBtn,socialBtn,myInfoBtn;
    private ImageView homePageIcon,creationIcon,socialIcon,myInfoIcon;
    private TextView homePageTxt,creationTxt,socialTxt,myInfoTxt;
    private ViewPager2 vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echo);
        initFragment();
        vp.setCurrentItem(0,false);

        tab = findViewById(R.id.tab_nav);

        homePageBtn = findViewById(R.id.home_page_bottom);
        creationBtn = findViewById(R.id.creation_bottom);
        socialBtn = findViewById(R.id.social_bottom);
        myInfoBtn = findViewById(R.id.my_info_bottom);

        homePageIcon = findViewById(R.id.nav_home_page_icon);
        creationIcon = findViewById(R.id.nav_creation_icon);
        socialIcon = findViewById(R.id.nav_social_icon);
        myInfoIcon = findViewById(R.id.nav_my_info_icon);

        homePageTxt = findViewById(R.id.nav_home_page_txt);
        creationTxt = findViewById(R.id.nav_creation_txt);
        socialTxt = findViewById(R.id.nav_social_txt);
        myInfoTxt = findViewById(R.id.nav_my_info_txt);


        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:

                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
                super.onPageSelected(position);
            }
        });
    }

    private void initFragment(){
        final List<Fragment> list=new ArrayList<>();
        list.add(new HomePageFragment());
        list.add(new CreationFragment());
        list.add(new SocialFragment());
        list.add(new MyInfoFragment());

        vp=findViewById(R.id.main_viewpager);               //获得ViewPager2控件
        //设置预加载的Fragment页面数量，可防止流式布局StaggeredGrid数组越界错误。
        vp.setOffscreenPageLimit(list.size() - 1);                                                                     													//设置适配器
        FragmentStateAdapter adapter=new FragmentStateAdapter(EchoActivity.this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return list.get(position);
            }
            @Override
            public int getItemCount() {
                return list.size();
            }
        };

        vp.setAdapter(adapter);                     //把适配器添加给ViewPager2
    }
    public void setSelected(){
        homePageBtn.setSelected(false);
        creationBtn.setSelected(false);
        socialBtn.setSelected(false);
        myInfoBtn.setSelected(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_page_bottom:
                setSelected();
                homePageBtn.setSelected(true);
                break;
            case R.id.creation_bottom:
                setSelected();
                creationBtn.setSelected(true);
                break;
            case R.id.social_bottom:
                setSelected();
                socialBtn.setSelected(true);
                break;
            case R.id.my_info_bottom:
                setSelected();
                myInfoBtn.setSelected(true);
                break;
        }
    }
}