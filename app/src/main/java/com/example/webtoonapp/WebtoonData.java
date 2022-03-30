package com.example.webtoonapp;

public class WebtoonData {

    public String img;
    public String title;
    public String sub_title;
    public String hit;
    public String rank;

    public WebtoonData(String img, String title, String sub_title, String hit, String rank) {
        this.img = img;
        this.title = title;
        this.sub_title = sub_title;
        this.hit = hit;
        this.rank = rank;
    }

    public WebtoonData() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "WebtoonData{" +
                "img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", sub_title='" + sub_title + '\'' +
                ", hit='" + hit + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
