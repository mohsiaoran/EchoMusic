package cn.edu.fjzzit.echomusic.entity;

public class ChosenInfo {
    private String image;
    private String title;
    private String author;
    private String content;

    public ChosenInfo(String image, String title, String author, String content) {
        this.image = image;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public ChosenInfo() {

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}