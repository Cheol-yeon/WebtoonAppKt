package com.example.webtoonapp;

public class KeywordWebtoonData {

    public String img;
    public String title;
    public String sub_title;

    public KeywordWebtoonData(String img, String title, String sub_title) {
        this.img = img;
        this.title = title;
        this.sub_title = sub_title;
    }

    public KeywordWebtoonData() {
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

    @Override
    public String toString() {
        return "KeywordWebtoonData{" +
                "img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", sub_title='" + sub_title + '\'' +
                '}';
    }
}
