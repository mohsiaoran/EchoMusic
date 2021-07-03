package cn.edu.fjzzit.echomusic.entity;

public class HallInfo {
    private String userName;
    private String postTime;
    private int state;
    private String author;
    private int image;
    private String title;
    private String content;

    public HallInfo (String userName ,String postTime,int state,String author,int image, String title ,String content){
        this.userName=userName;
        this.postTime=postTime;
        this.state=state;
        this.image=image;
        this.title=title;
        this.title=title;
        this.content=content;
        this.author = author;
    }

    public  HallInfo(){

    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public int getImage() {
        return image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
