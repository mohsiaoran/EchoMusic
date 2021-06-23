package cn.edu.fjzzit.echomusic.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.service.MusicService;

public class PlayActivity extends AppCompatActivity {

    ImageButton returnBtn;
    SeekBar seekBar;
    TextView nowTv,totalTv;
    Button playPageBtn;
    private MediaPlayer mediaPlayer;
    private Timer timer;
    private int playState;
    private MusicService musicService;
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

    //handler
    public Handler mUpdateHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            //接收到播放
            switch (msg.what) {
                //执行播放
                case MusicService.STATUS_PLAYING:
                    playPageBtn.setBackgroundResource(R.drawable.pause_lg);//设置按钮为暂停
                    EchoActivity.current_status = MusicService.STATUS_PLAYING;
                    EchoActivity.musicService.playOrPause();
                    break;
                //执行暂停
                case MusicService.STATUS_PAUSED:
                    playPageBtn.setBackgroundResource(R.drawable.play_lg);//设置按钮为播放
                    EchoActivity.current_status = MusicService.STATUS_PAUSED;
                    EchoActivity.musicService.playOrPause();
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
        setContentView(R.layout.activity_play);

        returnBtn = findViewById(R.id.play_page_return_btn);
        seekBar = findViewById(R.id.play_page_seekBar);
        nowTv = findViewById(R.id.play_time_now);
        totalTv = findViewById(R.id.play_time_total);
        playPageBtn = findViewById(R.id.play_page_btn);
        MusicService musicService;



        //从页面获取媒体信息
        mediaPlayer = MusicService.mediaPlayer;
        playState = EchoActivity.current_status;

        seekBar.getThumb().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_ATOP);
        seekBar.setMax(mediaPlayer.getDuration()/100);
        seekBar.setProgress(mediaPlayer.getCurrentPosition()/100);

        //初始化按钮
        switch (playState){
            case MusicService.STATUS_PLAYING:
                //.d("按钮状态:","stop");
                playPageBtn.setBackgroundResource(R.drawable.pause_lg);//设置按钮为暂停
                break;
            case MusicService.STATUS_PAUSED:
                //Log.d("按钮状态:","play");
                playPageBtn.setBackgroundResource(R.drawable.play_lg);//设置按钮为播放
                break;
        }

        //时间赋值
        nowTv.setText(getTime(mediaPlayer.getCurrentPosition()/1000));
        totalTv.setText(getTime(mediaPlayer.getDuration()/1000));

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //Log.d("test",String.valueOf(mediaPlayer.getCurrentPosition()));
                seekBar.setProgress(mediaPlayer.getCurrentPosition()/100);
            }},0,50);
        if(playState==MusicService.STATUS_PAUSED){
            timer.cancel();//stop
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            //进度调改变时
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int now = seekBar.getProgress();
                String timeDf = getTime(now/10);
                nowTv.setText(timeDf);
            }
            //开始拖动时
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //mediaPlayer.pause();
                timer.cancel();
            }
            //停止拖动时
            @Override
            public void onStopTrackingTouch(final SeekBar seekBar) {
                int progress = seekBar.getProgress();
                mediaPlayer.seekTo(progress*100);
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        //Log.d("test",String.valueOf(mediaPlayer.getCurrentPosition()));
                        seekBar.setProgress(mediaPlayer.getCurrentPosition()/100);
                    }},0,50);
                if(playState==MusicService.STATUS_PAUSED){
                    timer.cancel();//stop
                }
            }
        });

        //返回按钮
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EchoActivity.updataMediaState();
                finish();
            }
        });

        //播放按钮
        playPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("current_status:",String.valueOf(current_status));
                //Log.d("MusicService:",String.valueOf(MusicService.STATUS_PLAYING));
                switch (EchoActivity.current_status){
                    case MusicService.STATUS_STOPPED:
                        //Log.d("test:","1");
                        mUpdateHandler.sendEmptyMessage(MusicService.STATUS_PLAYING);
                        //playProgessBar.setMax(MusicService.mediaPlayer.getDuration()/100);
                        timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                //Log.d("test",String.valueOf(mediaPlayer.getCurrentPosition()));
                                seekBar.setProgress(MusicService.mediaPlayer.getCurrentPosition()/100);
                            }},0,50);
                        if(EchoActivity.current_status==MusicService.STATUS_PAUSED){
                            timer.cancel();//stop
                        }
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
    }


    private String getTime(int time){
        String timeDf;
        if(time < 3600){
            timeDf = String.format("%1$02d:%2$02d",time/60,time %60);
        }else{
            timeDf = String.format("%1$d:%2$02d:%3$02d",time/3600,time%3600/60,time%60);
        }
        return timeDf;
    }
}