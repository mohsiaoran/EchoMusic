package cn.edu.fjzzit.echomusic.utils;;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


import cn.edu.fjzzit.echomusic.activity.EchoActivity;
import cn.edu.fjzzit.echomusic.activity.LocalMusicActivity;
import cn.edu.fjzzit.echomusic.entity.MusicInfo;

/**
 * 音乐扫描工具
 *
 * @author llw
 */
public class MusicUtils {
    /**
     * 扫描系统里面的音频文件，返回一个list集合
     */
    public static List<MusicInfo> getMusicData(Context context) {
        List<MusicInfo> list = new ArrayList<MusicInfo>();
        // 媒体库查询语句（写一个工具类MusicUtils）
        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null, null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do{
                    MusicInfo song = new MusicInfo();
                    //歌曲名称
                    song.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)));
                    //Log.d("Utils:",cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)));
                    //歌手
                    song.setArtist(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)));
                    //歌曲路径
                    song.setDataPath(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)));
                    //song.path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                    //歌曲时长
                    //song.duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
                    //歌曲大小
                    long size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));
                    if (size > 1000 * 800) {
                        // 注释部分是切割标题，分离出歌曲名和歌手 （本地媒体库读取的歌曲信息不规范）
                        if (song.getTitle().contains("-")) {
                            String[] str = song.getTitle().split("-");
                            song.setArtist(str[0]);
                            song.setTitle(str[1]);
                            //song.song = str[1];
                        }
                        list.add(song);
                    }
                }while (cursor.moveToNext());

            }
            // 释放资源
            cursor.close();
        }
        return list;
    }

}
