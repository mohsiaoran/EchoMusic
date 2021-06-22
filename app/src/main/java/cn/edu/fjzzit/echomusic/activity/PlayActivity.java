package cn.edu.fjzzit.echomusic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import cn.edu.fjzzit.echomusic.R;

public class PlayActivity extends AppCompatActivity {

    ImageButton returnBtn;
    SeekBar seekBar;
    TextView nowTv,totalTv;
    private MediaPlayer mediaPlayer;
    private Timer timer;
    private boolean playState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        returnBtn = findViewById(R.id.play_page_return_btn);
        seekBar = findViewById(R.id.play_page_seekBar);
        nowTv = findViewById(R.id.play_time_now);
        totalTv = findViewById(R.id.play_time_total);

        //从页面获取媒体信息
        mediaPlayer = EchoActivity.mediaPlayer1;
        playState = EchoActivity.playState;

        seekBar.getThumb().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_ATOP);
        seekBar.setMax(mediaPlayer.getDuration()/1000);
        //时间赋值
        totalTv.setText(getTime(mediaPlayer.getDuration()/1000));

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //Log.d("test",String.valueOf(mediaPlayer.getCurrentPosition()));
                seekBar.setProgress(mediaPlayer.getCurrentPosition()/1000);
            }},0,50);
        if(!playState){
            timer.cancel();//stop
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            //进度调改变时
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int now = seekBar.getProgress();
                String timeDf = getTime(now);
                nowTv.setText(timeDf);
            }
            //开始拖动时
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //mediaPlayer.pause();
                timer.purge();
            }
            //停止拖动时
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                mediaPlayer.seekTo(progress*1000);
            }
        });

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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