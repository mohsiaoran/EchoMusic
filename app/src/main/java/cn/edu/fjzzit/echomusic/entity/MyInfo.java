package cn.edu.fjzzit.echomusic.entity;

import java.io.Serializable;

public class MyInfo implements Serializable {
    private String id;
    private String name;
    private String level;
    private String sign;
    private String attention;
    private String dynamic;
    private String fans;
    private String news;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getDynamic() {
        return dynamic;
    }

    public void setDynamic(String dynamic) {
        this.dynamic = dynamic;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "MyInfo{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", sign='" + sign + '\'' +
                ", attention='" + attention + '\'' +
                ", dynamic='" + dynamic + '\'' +
                ", fans='" + fans + '\'' +
                ", news='" + news + '\'' +
                '}';
    }
}
