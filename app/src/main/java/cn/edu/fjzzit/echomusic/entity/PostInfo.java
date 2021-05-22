package cn.edu.fjzzit.echomusic.entity;

public class PostInfo {
    private String userName;
    private String postTime;
    private String postContent;

    public PostInfo(String userName, String postTime, String postContent) {
        this.userName = userName;
        this.postTime = postTime;
        this.postContent = postContent;
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
