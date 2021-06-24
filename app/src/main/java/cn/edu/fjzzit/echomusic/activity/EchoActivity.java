package cn.edu.fjzzit.echomusic.activity;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.service.MusicService;

public class EchoActivity extends AppCompatActivity{
    private LinearLayout homePageBtn,creationBtn,socialBtn,myInfoBtn;
    private ImageView homePageIcon,creationIcon,socialIcon,myInfoIcon;
    private TextView homePageTxt,creationTxt,socialTxt,myInfoTxt;
    private ViewPager2 vp;
    private TabLayout nav;
    private List<Fragment> fragmentList = new ArrayList<>();
    private int[] titleList = new int[]{R.string.find,R.string.creation,R.string.social,R.string.my_info};
    private int[] iconList = new int[]{R.drawable.tab_icon_home_page,
            R.drawable.tab_icon_creation,
            R.drawable.tab_icon_social,
            R.drawable.tab_icon_my_info};
    private String flag = "true";
    private String TAG = "TAG";
    public static MediaPlayer mediaPlayer1 = null;
    public static boolean playState = false;
    //private MyReceiver myreceiver;
    private static String sID = "2131623937";
    private ImageView musicImg;
    private ConstraintLayout playBar;
    public static Button barPlayBtn;
    public static ProgressBar playProgessBar;
    //当前播放的歌曲,播放状态,播放进度,当前的歌曲的总时长,当前播放模式
    public static int current_number,current_status,current_progress,duration,current_PlayMode;
    private Timer timer;


    //handler
    public Handler mUpdateHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            //接收到播放
            switch(msg.what){
                //执行播放
                case MusicService.STATUS_PLAYING:
                    barPlayBtn.setBackgroundResource(R.drawable.pause);//设置按钮为暂停
                    current_status = MusicService.STATUS_PLAYING;
                    musicService.playOrPause();
                    break;
                //执行暂停
                case MusicService.STATUS_PAUSED:
                    barPlayBtn.setBackgroundResource(R.drawable.play);//设置按钮为播放
                    current_status = MusicService.STATUS_PAUSED;
                    musicService.playOrPause();
                    break;
                //播放结束执行    /
                case MusicService.STATUS_STOPPED:
                    break;
                case MusicService.STATUS_COMPLETED:
                    break;
            }
            return false;
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echo);
        //存储权限获取
        verifyStoragePermissions(this);

        //初始化
        playBar = findViewById(R.id.music_play_bar);
        barPlayBtn = findViewById(R.id.btn_play);
        playProgessBar = findViewById(R.id.play_bar_progressBar);
        musicImg = findViewById(R.id.play_bar_music_info_img);
        bindServiceConnection();
        musicService = new MusicService();
        musicService.animator = ObjectAnimator.ofFloat(musicImg, "rotation", 0, 359);

        switch (current_status) {
            case MusicService.STATUS_PLAYING:
                //Log.d("test:","1");
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        //Log.d("test",String.valueOf(mediaPlayer.getCurrentPosition()));
                        playProgessBar.setProgress(MusicService.mediaPlayer.getCurrentPosition() / 100);
                        current_progress = playProgessBar.getProgress();
                        //Log.d("progress:",String.valueOf(current_progress));
                        if (current_status == MusicService.STATUS_PAUSED) {
                            timer.cancel();//stop
                        }
                    }
                }, 0, 50);
                break;
        }

        //获取intent里面的信息
        Intent myIntent = getIntent();
        current_number = myIntent.getIntExtra("current_number",0);
        current_status = myIntent.getIntExtra("current_status", MusicService.STATUS_STOPPED);
        current_progress = myIntent.getIntExtra("current_progress",0);

        init();
        vp.setCurrentItem(0,false);

        //打开play页面
        playBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(EchoActivity.this, PlayActivity.class);
                EchoActivity.this.startActivity(intent);
            }
        });

        //播放按钮
        barPlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("current_status:",String.valueOf(current_status));
                //Log.d("MusicService:",String.valueOf(MusicService.STATUS_PLAYING));
                switch (current_status){
                    case MusicService.STATUS_STOPPED:
                        //Log.d("test:","1");
                        mUpdateHandler.sendEmptyMessage(MusicService.STATUS_PLAYING);
                        playProgessBar.setMax(MusicService.mediaPlayer.getDuration()/100);

                        timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                //Log.d("test",String.valueOf(mediaPlayer.getCurrentPosition()));
                                playProgessBar.setProgress(MusicService.mediaPlayer.getCurrentPosition()/100);
                                current_progress = playProgessBar.getProgress();
                                //Log.d("progress:",String.valueOf(current_progress));
                                if(current_status==MusicService.STATUS_PAUSED) {
                                    timer.cancel();//stop
                                }
                            }},0,50);
                        break;
                    case MusicService.STATUS_PLAYING:
                        //Log.d("test:","2");
                        mUpdateHandler.sendEmptyMessage(MusicService.STATUS_PAUSED);
                        break;
                    case MusicService.STATUS_PAUSED:
                        //Log.d("test:","3");
                        mUpdateHandler.sendEmptyMessage(MusicService.STATUS_PLAYING);
                        break;
                }
            }
        });


        /*//定位音乐播放图标
        btn_play=(Button) findViewById(R.id.btn_play);
        if(mediaPlayer1 == null){
            mediaPlayer1 = MediaPlayer.create(EchoActivity.this, R.raw.canon); //默认播放canon
        }

        //添加音乐播放按钮的监听器
        btn_play.setOnClickListener(new View.OnClickListener(){
            //音乐播放与暂停
            @Override
            public void onClick(View v) {
                if(flag.equals("true")){
                    // 音频开始
                    mediaPlayer1.start();
                    playState = true;
                    // 切换暂停图标
                    Resources resources = getApplicationContext().getResources();
                    Drawable pause = resources.getDrawable(R.drawable.pause);
                    btn_play.setBackground(pause);
                    playProgessBar.setMax(mediaPlayer1.getDuration());
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if(playState){
                                //Log.d(TAG, " test");
                                playProgessBar.setProgress(mediaPlayer1.getCurrentPosition());
                            }
                        }
                    },0,50);
                    flag = "false";
                }else{
                    // 音频暂停
                    mediaPlayer1.pause();
                    playState = false;
                    timer.purge(); //定时器停止
                    // 切换播放图标
                    Resources resources = getApplicationContext().getResources();
                    Drawable play = resources.getDrawable(R.drawable.play);
                    btn_play.setBackground(play);
                    flag = "true";
                }
            }
        });*/

        // 弹出底部音乐列表
        View musicList= (View) findViewById(R.id.musicList);
        //添加监听器
        musicList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DialogActivity dialogActivity = new DialogActivity(EchoActivity.this);
                dialogActivity.show();
            }
        });

        //注册“网络变化”的广播接收器
        //myreceiver = new MyReceiver();
        //实例化过滤器并设置要过滤的广播
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.test.send.message");
        //注册广播
        //EchoActivity.this.registerReceiver(myreceiver, intentFilter);

        //播放bar点击事件
        playBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(EchoActivity.this, PlayActivity.class);
                EchoActivity.this.startActivity(intent);
            }
        });

        //播放按钮触摸事件

        //进度条处理


    }

    /*// 广播
    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("com.test.send.message")) {
                mediaPlayer1.release();
                // 接收到广播传来的数据
                sID = intent.getStringExtra("id");
                // 播放列表选中的音乐
                int id = Integer.parseInt(sID);                 //String转int
                mediaPlayer1 = MediaPlayer.create(EchoActivity.this, id);
                mediaPlayer1.start();
                Resources resources = getApplicationContext().getResources();
                Drawable pause = resources.getDrawable(R.drawable.pause);
                btn_play.setBackground(pause);
            } else {
                Log.d(TAG, "MyReceiver error");
            }
        }
    }
*/
    public static void updataMediaState(){
        playProgessBar.setMax(MusicService.mediaPlayer.getDuration()/100);
        playProgessBar.setProgress(MusicService.mediaPlayer.getCurrentPosition()/100);
        //初始化按钮
        switch (EchoActivity.current_status){
            case MusicService.STATUS_PLAYING:
                barPlayBtn.setBackgroundResource(R.drawable.pause);//设置按钮为暂停
                break;
            case MusicService.STATUS_PAUSED:
                barPlayBtn.setBackgroundResource(R.drawable.play);//设置按钮为播放
                break;
        }
    }

    public static MusicService musicService;
    private SimpleDateFormat time = new SimpleDateFormat("mm:ss");
    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            musicService = ((MusicService.MyBinder) iBinder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            musicService = null;
        }
    };

    private void bindServiceConnection() {
        Intent intent = new Intent(this, MusicService.class);
        startService(intent);
        bindService(intent, sc, this.BIND_AUTO_CREATE);
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

    //设置返回键不推出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // Storage Permissions//存储权限
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    /**
     * Checks if the app has permission to write to device storage
     *
     * If the app does not has permission then the user will be prompted to grant permissions
     *
     * @param activity
     */
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

}