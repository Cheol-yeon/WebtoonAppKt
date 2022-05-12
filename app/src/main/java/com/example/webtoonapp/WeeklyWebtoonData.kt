package com.example.webtoonapp

class WeeklyWebtoonData {
    var img: String? = null
    var title: String? = null
    var subTitle: String? = null
    var hit: String? = null

    constructor(img: String?, title: String?, subTitle: String?, hit: String?) {
        this.img = img
        this.title = title
        this.subTitle = subTitle
        this.hit = hit
    }

    constructor() {}
}