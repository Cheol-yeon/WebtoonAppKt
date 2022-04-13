package com.example.webtoonapp;

public class WeeklyWebtoonData {

    public String img;
    public String title;
    public String subTitle;
    public String hit;

    public WeeklyWebtoonData(String img, String title, String subTitle, String hit) {
        this.img = img;
        this.title = title;
        this.subTitle = subTitle;
        this.hit = hit;
    }

    public WeeklyWebtoonData() {
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

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }
}
