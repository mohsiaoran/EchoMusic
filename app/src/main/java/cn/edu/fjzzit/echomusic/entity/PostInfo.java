package cn.edu.fjzzit.echomusic.entity;


//动态
public class PostInfo {
    private String userName;
    private String postTime;
    private String postContent;
    private int state;

    public PostInfo(String userName, String postTime, String postContent, int state) {
        this.userName = userName;
        this.postTime = postTime;
        this.postContent = postContent;
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public PostInfo() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}
