package cn.edu.fjzzit.echomusic.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    String flag = "true";
    String TAG = "";
    Button btn_play;
    MediaPlayer mediaPlayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echo);

        init();
        vp.setCurrentItem(0,false);


        //定位音乐播放图标
        btn_play=(Button) findViewById(R.id.btn_play);
        if(mediaPlayer1 == null){
            mediaPlayer1 = MediaPlayer.create(EchoActivity.this, 2131623936);   //默认播放canon
        }

        //添加监听器
        btn_play.setOnClickListener(new View.OnClickListener(){
            //音乐播放与暂停
            @Override
            public void onClick(View v) {
                if(flag.equals("true")){
                    mediaPlayer1.start();
                    flag = "false";
                }else{
                    mediaPlayer1.pause();
                    flag = "true";
                }
            }
        });

        // 弹出底部音乐列表
        View musicList= (View) findViewById(R.id.musicList);
        //添加监听器
        musicList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mediaPlayer1.release();
                DialogActivity dialogActivity = new DialogActivity(EchoActivity.this);
                dialogActivity.show();

            }
        });

        // 音乐列表播放
        String sID=getIntent().getStringExtra("id");
        while(sID != null){

            int id=Integer.parseInt(sID);      //String转int


            mediaPlayer1 = MediaPlayer.create(EchoActivity.this, id);
            mediaPlayer1.start();
            //添加监听器
            sID = null;
        }




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

                tab.setIcon(iconList[position]);
                tab.setText(titleList[position]);
            }
        }).attach();
    }


}