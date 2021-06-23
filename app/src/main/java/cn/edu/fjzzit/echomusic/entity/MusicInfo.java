package cn.edu.fjzzit.echomusic.entity;

import android.graphics.Bitmap;

//音乐
public class MusicInfo {
    private String title;//歌名
    private String artist;//  歌手
    private long duration;//时长
    private String dataPath;//歌曲文件路径
    private boolean isLove;//是否是喜爱的歌曲
    private Bitmap album_icon;
    private boolean isDefaultAlbumIcon;

    public MusicInfo() {
    }

    public MusicInfo(String title, String artist, long duration, String dataPath, boolean isLove, Bitmap album_icon, boolean isDefaultAlbumIcon) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.dataPath = dataPath;
        this.isLove = isLove;
        this.album_icon = album_icon;
        this.isDefaultAlbumIcon = isDefaultAlbumIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getDataPath() {
        return dataPath;
    }

    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    public boolean isLove() {
        return isLove;
    }

    public void setLove(boolean love) {
        isLove = love;
    }

    public Bitmap getAlbum_icon() {
        return album_icon;
    }

    public void setAlbum_icon(Bitmap album_icon) {
        this.album_icon = album_icon;
    }

    public boolean isDefaultAlbumIcon() {
        return isDefaultAlbumIcon;
    }

    public void setDefaultAlbumIcon(boolean defaultAlbumIcon) {
        isDefaultAlbumIcon = defaultAlbumIcon;
    }
}
