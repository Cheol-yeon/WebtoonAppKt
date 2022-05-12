package com.example.webtoonapp

class WebtoonEpisodeData {
    var thumbnail1: String? = null
    var thumbnail2: String? = null
    var episode_title: String? = null
    var episode_stitle: String? = null
    var episode_date: String? = null

    constructor(
        thumbnail1: String?,
        thumbnail2: String?,
        episode_title: String?,
        episode_stitle: String?,
        episode_date: String?
    ) {
        this.thumbnail1 = thumbnail1
        this.thumbnail2 = thumbnail2
        this.episode_title = episode_title
        this.episode_stitle = episode_stitle
        this.episode_date = episode_date
    }

    constructor() {}
}