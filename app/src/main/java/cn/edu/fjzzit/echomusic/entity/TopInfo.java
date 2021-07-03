package cn.edu.fjzzit.echomusic.entity;

//排行榜
public class TopInfo {
    private int imageId;
    private String title;
    private String author;
    private String content;

    public TopInfo(int imageId, String title, String author, String content) {
        this.imageId = imageId;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public TopInfo() {

    }

    public int getImage() {
        return imageId;
    }

    public void setImage(int image) {
        this.imageId = image;
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
