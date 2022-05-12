package com.example.webtoonapp

class WebtoonData {
    var img: String? = null
    var title: String? = null
    var sub_title: String? = null

    constructor(img: String?, title: String?, sub_title: String?) {
        this.img = img
        this.title = title
        this.sub_title = sub_title
    }

    constructor() {}

    override fun toString(): String {
        return "KeywordWebtoonData{" +
                "img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", sub_title='" + sub_title + '\'' +
                '}'
    }
}