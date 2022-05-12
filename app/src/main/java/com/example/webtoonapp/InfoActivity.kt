package com.example.webtoonapp

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.recyclerview.widget.RecyclerView
import com.example.webtoonapp.WebtoonEpisodeData
import android.os.Bundle
import com.example.webtoonapp.R
import androidx.recyclerview.widget.LinearLayoutManager
import android.content.Intent
import android.graphics.Paint
import android.view.View
import com.example.webtoonapp.MainActivity
import com.example.webtoonapp.EpidoseRecyclerViewAdapter
import java.util.ArrayList

class InfoActivity : AppCompatActivity() {
    var org_coin: AppCompatTextView? = null
    var icon_back: ImageFilterView? = null
    var infoRecyclerview: RecyclerView? = null
    var infoRecyclerviewlayoutManager: RecyclerView.LayoutManager? = null
    var infoRecyclerviewAdapter: RecyclerView.Adapter<*>? = null
    var webtoonEpisodeData: WebtoonEpisodeData? = null
    var webtoonEpisodeDataArrayList: ArrayList<WebtoonEpisodeData>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        org_coin = findViewById(R.id.tv_org_coin)
        icon_back = findViewById(R.id.iv_icon_back)
        infoRecyclerview = findViewById(R.id.rv_infoWebtoonlist)
//        org_coin?.setPaintFlags(org_coin?.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
        icon_back?.setOnClickListener(View.OnClickListener { onBackPressed() })
        val title = "편의점 샛별이"
        infoRecyclerview?.setHasFixedSize(true)
        infoRecyclerviewlayoutManager = LinearLayoutManager(this)
        infoRecyclerview?.setLayoutManager(infoRecyclerviewlayoutManager)
        getData(title)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }

    fun getData(title: String?) {
        webtoonEpisodeDataArrayList = ArrayList()
        for (i in 0..9) {
            webtoonEpisodeData = WebtoonEpisodeData()
            webtoonEpisodeData!!.thumbnail1 =
                "https://shtosebzjw.akamaized.net/assets/upfile/ep_thumb2/5412_112522_1578979220.2275.jpg"
            webtoonEpisodeData!!.thumbnail2 =
                "https://shtosebzjw.akamaized.net/assets/upfile/ep_thumb3/5412_112522_1578979220.2337.jpg"
            webtoonEpisodeData!!.episode_title = "제1화"
            webtoonEpisodeData!!.episode_stitle = "첫 만남, 첫 키스(?)"
            webtoonEpisodeData!!.episode_date = "16.08.27"
            webtoonEpisodeDataArrayList!!.add(webtoonEpisodeData!!)
        }
        infoRecyclerviewAdapter = EpidoseRecyclerViewAdapter(webtoonEpisodeDataArrayList, this)
        infoRecyclerview!!.adapter = infoRecyclerviewAdapter
    }
}