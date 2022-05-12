package com.example.webtoonapp

class RankingWebtoonData {
    var img: String? = null
    var title: String? = null
    var sub_title: String? = null
    var hit: String? = null
    var rank: String? = null

    constructor(img: String?, title: String?, sub_title: String?, hit: String?, rank: String?) {
        this.img = img
        this.title = title
        this.sub_title = sub_title
        this.hit = hit
        this.rank = rank
    }

    constructor() {}

    override fun toString(): String {
        return "WebtoonData{" +
                "img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", sub_title='" + sub_title + '\'' +
                ", hit='" + hit + '\'' +
                ", rank='" + rank + '\'' +
                '}'
    }
}