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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.fjzzit.echomusic.R;

public class EchoActivity extends AppCompatActivity{

    private LinearLayout homePageBtn,creationBtn,socialBtn,myInfoBtn;
    private ImageView homePageIcon,creationIcon,socialIcon,myInfoIcon;
    private TextView homePageTxt,creationTxt,socialTxt,myInfoTxt;
    private ViewPager2 vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echo);

        initFragment();
        vp.setCurrentItem(0,false);

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

        homePageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp.setCurrentItem(0,false);

                homePageIcon.setImageResource(R.drawable.earth);
                creationIcon.setImageResource(R.drawable.lights_cray);
                socialIcon.setImageResource(R.drawable.social_cray);
                myInfoIcon.setImageResource(R.drawable.myinfo_cray);

                homePageTxt.setTextColor(Color.parseColor("#152B93"));
                creationTxt.setTextColor(Color.parseColor("#797979"));
                socialTxt.setTextColor(Color.parseColor("#797979"));
                myInfoTxt.setTextColor(Color.parseColor("#797979"));
            }
        });

        creationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp.setCurrentItem(1,false);

                homePageIcon.setImageResource(R.drawable.earth_cray);
                creationIcon.setImageResource(R.drawable.lights);
                socialIcon.setImageResource(R.drawable.social_cray);
                myInfoIcon.setImageResource(R.drawable.myinfo_cray);

                homePageTxt.setTextColor(Color.parseColor("#797979"));
                creationTxt.setTextColor(Color.parseColor("#152B93"));
                socialTxt.setTextColor(Color.parseColor("#797979"));
                myInfoTxt.setTextColor(Color.parseColor("#797979"));
            }
        });

        socialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp.setCurrentItem(2,false);

                homePageIcon.setImageResource(R.drawable.earth_cray);
                creationIcon.setImageResource(R.drawable.lights_cray);
                socialIcon.setImageResource(R.drawable.social);
                myInfoIcon.setImageResource(R.drawable.myinfo_cray);

                homePageTxt.setTextColor(Color.parseColor("#797979"));
                creationTxt.setTextColor(Color.parseColor("#797979"));
                socialTxt.setTextColor(Color.parseColor("#152B93"));
                myInfoTxt.setTextColor(Color.parseColor("#797979"));
            }
        });

        myInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp.setCurrentItem(3,false);

                homePageIcon.setImageResource(R.drawable.earth_cray);
                creationIcon.setImageResource(R.drawable.lights_cray);
                socialIcon.setImageResource(R.drawable.social_cray);
                myInfoIcon.setImageResource(R.drawable.myinfo);

                homePageTxt.setTextColor(Color.parseColor("#797979"));
                creationTxt.setTextColor(Color.parseColor("#797979"));
                socialTxt.setTextColor(Color.parseColor("#797979"));
                myInfoTxt.setTextColor(Color.parseColor("#152B93"));
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
}