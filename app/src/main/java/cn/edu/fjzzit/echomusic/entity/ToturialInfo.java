package cn.edu.fjzzit.echomusic.entity;


//教程
public class ToturialInfo {
    private int imgRes;
    private String title;
    private String good;
    private String url;

    public ToturialInfo(int imgRes, String content, String good, String url) {
        this.imgRes = imgRes;
        this.title = content;
        this.good = good;
        this.url = url;
    }

    public ToturialInfo() {
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
