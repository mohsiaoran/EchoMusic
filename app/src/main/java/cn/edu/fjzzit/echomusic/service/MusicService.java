package cn.edu.fjzzit.echomusic.service;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.view.animation.LinearInterpolator;

import cn.edu.fjzzit.echomusic.R;
import cn.edu.fjzzit.echomusic.activity.EchoActivity;

public class MusicService extends Service {
    //广播标识
    public static final String BROADCAST_MUSICSERVICE_CONTROL = "MusicService.ACTTION_CONTROL";
    public static final String BROADCAST_MUSICSERVICE_UPDATE_STATUS = "MusicService.ACTTION_UPDATE";
    public static final String BROADCAST_MUSICSERVICE_PROGRESS = "MusicService.PROGRESS";
    //播放器状态
    public static final int STATUS_PLAYING = 0;
    public static final int STATUS_PAUSED = 1;
    public static final int STATUS_STOPPED = 2;
    public static final int STATUS_COMPLETED = 3;
    //    public static final int STATUS_PREVIOUS = 4;
    //progressBar相关
    public static final int PROGRESS_UPDATE = 4;
    public static final int PROGRESS_DURATION = 5;
    //播放模式已更新
    public static final int PLAY_MODE_UPDATE = 6;
    //播放控制命令
    public static final int COMMAND_UNKNOWN = -1;
    public static final int COMMAND_PLAY = 0;
    public static final int COMMAND_PAUSE = 1;
    //    public static final int COMMAND_STOP = 2;
    public static final int COMMAND_RESUME = 3;
    public static final int COMMAND_PREVIOUS = 4;
    public static final int COMMAND_NEXT = 5;
    public static final int COMMAND_REQUEST_DURATION = 6;//请求当前歌曲的总时长
    //播放顺序命令
    public static final int PLAY_MODE_ORDER = 8;//顺序播放(默认是它)
    public static final int PLAY_MODE_LOOP = 9;//单曲循环
    public static final int PLAY_MODE_RANDOM = 10;//随机播放
    public static final int COMMAND_SEEK_TO = 11;//seekTo控制播放命令

    public final IBinder binder = new MyBinder();
    public class MyBinder extends Binder {
       public MusicService getService() {
            return MusicService.this;
        }
    }

    public static int isReturnTo = 0;
    public static MediaPlayer mediaPlayer = new MediaPlayer();
    public static ObjectAnimator animator;
    public MusicService() {
        initMediaPlayer();
    }

    public void initMediaPlayer() {
        try {
            if (!mediaPlayer.isPlaying()) {
                //String file_path = "/storage/0123-4567/K.Will-Melt.mp3";
                String file_path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/canon.mp3";
                //String file_path = "/data/K.Will-Melt.mp3";
                //mediaPlayer.create(getBaseContext(), R.raw.canon);
                mediaPlayer.setDataSource(file_path);
                mediaPlayer.prepare();
                mediaPlayer.setLooping(true);  // 设置循环播放
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void AnimatorAction() {
        if (mediaPlayer.isPlaying()) {
            animator.setDuration(5000);
            animator.setInterpolator(new LinearInterpolator()); // 均速旋转
            animator.setRepeatCount(ValueAnimator.INFINITE); // 无限循环
            animator.setRepeatMode(ValueAnimator.RESTART);
            animator.start();
        }
    }
    private int flag = 0;
    public static String which = "";
    public void playOrPause() {
        flag++;
        if (flag >= 1000) flag = 2;

        which = "pause";

        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            animator.pause();
        } else {
            mediaPlayer.start();
            if ((flag == 1) || (isReturnTo == 1)) {
                animator.setDuration(5000);
                animator.setInterpolator(new LinearInterpolator()); // 均速旋转
                animator.setRepeatCount(ValueAnimator.INFINITE); // 无限循环
                animator.setRepeatMode(ValueAnimator.RESTART);
                animator.start();
            } else {
                animator.resume();
            }
        }
    }
    public void stop() {
        which = "stop";
        animator.pause();
        if(mediaPlayer != null) {
            mediaPlayer.pause();
            mediaPlayer.stop();
            try {
                mediaPlayer.prepare();
                mediaPlayer.seekTo(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onDestroy();
    }
    /**
     * onBind 是 Service 的虚方法，因此我们不得不实现它。
     * 返回 null，表示客服端不能建立到此服务的连接。
     */
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }



}