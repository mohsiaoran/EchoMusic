package cn.edu.fjzzit.echomusic.entity;

//分类的分类模块
public class SortInfo{
    private int sortImage;
    private String sortTitle;

    public SortInfo(int sortImage, String sortTitle) {
        this.sortImage = sortImage;
        this.sortTitle = sortTitle;

    }

    public SortInfo() {

    }

    public int getSortImage() {
        return sortImage;
    }

    public void setSortImage(int sortImage) {
        this.sortImage = sortImage;
    }

    public String getSortTitle() {
        return sortTitle;
    }

    public void setSortTitle(String sortTitle) {
        this.sortTitle = sortTitle;
    }

}