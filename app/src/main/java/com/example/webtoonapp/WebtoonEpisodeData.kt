package com.example.webtoonapp;

public class WebtoonEpisodeData {

    private String thumbnail1;
    private String thumbnail2;
    private String episode_title;
    private String episode_stitle;
    private String episode_date;

    public WebtoonEpisodeData(String thumbnail1, String thumbnail2, String episode_title, String episode_stitle, String episode_date) {
        this.thumbnail1 = thumbnail1;
        this.thumbnail2 = thumbnail2;
        this.episode_title = episode_title;
        this.episode_stitle = episode_stitle;
        this.episode_date = episode_date;
    }

    public WebtoonEpisodeData() {
    }

    public String getThumbnail1() {
        return thumbnail1;
    }

    public void setThumbnail1(String thumbnail1) {
        this.thumbnail1 = thumbnail1;
    }

    public String getThumbnail2() {
        return thumbnail2;
    }

    public void setThumbnail2(String thumbnail2) {
        this.thumbnail2 = thumbnail2;
    }

    public String getEpisode_title() {
        return episode_title;
    }

    public void setEpisode_title(String episode_title) {
        this.episode_title = episode_title;
    }

    public String getEpisode_stitle() {
        return episode_stitle;
    }

    public void setEpisode_stitle(String episode_stitle) {
        this.episode_stitle = episode_stitle;
    }

    public String getEpisode_date() {
        return episode_date;
    }

    public void setEpisode_date(String episode_date) {
        this.episode_date = episode_date;
    }
}
