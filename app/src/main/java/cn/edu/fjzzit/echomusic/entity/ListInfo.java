package cn.edu.fjzzit.echomusic.entity;

//曲集中的曲单
public class ListInfo {
    private int listImage;
    private String listTitle;

    public ListInfo(int listImage, String listTitle) {
        this.listImage = listImage;
        this.listTitle = listTitle;

    }

    public ListInfo() {

    }

    public int getListImage() {
        return listImage;
    }

    public void setListImage(int listImage) {
        this.listImage = listImage;
    }

    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

}
