package com.example.webtoonapp

import androidx.recyclerview.widget.RecyclerView
import com.example.webtoonapp.RankingWebtoonData
import android.os.Bundle
import com.example.webtoonapp.RankingFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.webtoonapp.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webtoonapp.RankingRecyclerViewAdapter
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 * Use the [RankingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RankingFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<*>? = null
    var rankingWebtoonData: RankingWebtoonData? = null
    var rankingWebtoonDataArrayList: ArrayList<RankingWebtoonData>? = null

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = requireArguments().getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ranking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rv_ranking)
        recyclerView?.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(requireActivity())
        recyclerView?.setLayoutManager(layoutManager)
        setWebtoonData()
    }

    fun setWebtoonData() {
        rankingWebtoonDataArrayList = ArrayList()
        if (mParam1 === "Realtime") {
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/5412_1580460555.8501.jpg"
            rankingWebtoonData!!.title = "????????? ?????????"
            rankingWebtoonData!!.sub_title = "???67??? ?????????-????????????"
            rankingWebtoonData!!.hit = "5,803???"
            rankingWebtoonData!!.rank = "1???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10291_1558085744.1762.jpg"
            rankingWebtoonData!!.title = "???????????? ?????????"
            rankingWebtoonData!!.sub_title = "???168???-?????? ?????? ??????????????? ??????"
            rankingWebtoonData!!.hit = "1,942???"
            rankingWebtoonData!!.rank = "2???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10415_1591248416.2574.jpg"
            rankingWebtoonData!!.title = "H-mate"
            rankingWebtoonData!!.sub_title = "???75??? ?????????-????????????"
            rankingWebtoonData!!.hit = "46???"
            rankingWebtoonData!!.rank = "3???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10609_1619599386.7538.jpg"
            rankingWebtoonData!!.title = "?????????, ???????????? ????????????"
            rankingWebtoonData!!.sub_title = "???289??? ?????????"
            rankingWebtoonData!!.hit = "48???"
            rankingWebtoonData!!.rank = "4???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10586_1614672726.6089.jpg"
            rankingWebtoonData!!.title = "??????????????? ??????"
            rankingWebtoonData!!.sub_title = "??????1 ?????????"
            rankingWebtoonData!!.hit = "6.5???"
            rankingWebtoonData!!.rank = "5???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10340_1566267954.1921.jpg"
            rankingWebtoonData!!.title = "????????? ????????????:????????????"
            rankingWebtoonData!!.sub_title = "???412???"
            rankingWebtoonData!!.hit = "11???"
            rankingWebtoonData!!.rank = "6???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)

//            for(int i=0; i<webtoonDataArrayList.size(); i ++) {
//                Log.e("RankingAdapter", "RankingAdapterListItem = " + webtoonDataArrayList.get(i));
//            }
        } else if (mParam1 === "Update") {
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10828_1645411050.2519.jpg"
            rankingWebtoonData!!.title = "????????????"
            rankingWebtoonData!!.sub_title = "???134???"
            rankingWebtoonData!!.hit = "5???"
            rankingWebtoonData!!.rank = "1???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10568_1604900784.8631.jpg"
            rankingWebtoonData!!.title = "???????????? ???????????? ?????? ??????"
            rankingWebtoonData!!.sub_title = "???410???"
            rankingWebtoonData!!.hit = "95???"
            rankingWebtoonData!!.rank = "2???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10859_1646896306.4209.jpg"
            rankingWebtoonData!!.title = "????????? ????????????"
            rankingWebtoonData!!.sub_title = "???80??? ?????????"
            rankingWebtoonData!!.hit = "5???"
            rankingWebtoonData!!.rank = "3???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10815_1644219619.8057.jpg"
            rankingWebtoonData!!.title = "????????? ??????"
            rankingWebtoonData!!.sub_title = "???47???"
            rankingWebtoonData!!.hit = "5???"
            rankingWebtoonData!!.rank = "4???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10532_1596439274.1639.jpg"
            rankingWebtoonData!!.title = "????????? ???????????????"
            rankingWebtoonData!!.sub_title = "???207???"
            rankingWebtoonData!!.hit = "29???"
            rankingWebtoonData!!.rank = "5???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10830_1645410926.1581.jpg"
            rankingWebtoonData!!.title = "????????????"
            rankingWebtoonData!!.sub_title = "???94???"
            rankingWebtoonData!!.hit = "5???"
            rankingWebtoonData!!.rank = "6???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)

//            for(int i=0; i<webtoonDataArrayList.size(); i ++) {
//                Log.e("RankingAdapter", "RankingAdapterListItem = " + webtoonDataArrayList.get(i));
//            }
        } else if (mParam1 === "New") {
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10848_1646639017.4464.jpg"
            rankingWebtoonData!!.title = "?????? ???????????? ????????????"
            rankingWebtoonData!!.sub_title = "???71???"
            rankingWebtoonData!!.hit = "5???"
            rankingWebtoonData!!.rank = "1???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10850_1646644712.7923.jpg"
            rankingWebtoonData!!.title = "?????? ????????? ???????????? ????????????"
            rankingWebtoonData!!.sub_title = "???27???"
            rankingWebtoonData!!.hit = "5???"
            rankingWebtoonData!!.rank = "2???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10816_1644220013.7383.jpg"
            rankingWebtoonData!!.title = "?????? ?????? ??????"
            rankingWebtoonData!!.sub_title = "???67???"
            rankingWebtoonData!!.hit = "5???"
            rankingWebtoonData!!.rank = "3???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10831_1645411113.0887.jpg"
            rankingWebtoonData!!.title = "?????? ??????"
            rankingWebtoonData!!.sub_title = "???89???"
            rankingWebtoonData!!.hit = "5???"
            rankingWebtoonData!!.rank = "4???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10815_1644219619.8057.jpg"
            rankingWebtoonData!!.title = "????????? ??????"
            rankingWebtoonData!!.sub_title = "???47???"
            rankingWebtoonData!!.hit = "5???"
            rankingWebtoonData!!.rank = "5???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10852_1646644078.0962.jpg"
            rankingWebtoonData!!.title = "????????? ????????????"
            rankingWebtoonData!!.sub_title = "???32???"
            rankingWebtoonData!!.hit = "5???"
            rankingWebtoonData!!.rank = "6???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)

//            for(int i=0; i<webtoonDataArrayList.size(); i ++) {
//                Log.e("RankingAdapter", "RankingAdapterListItem = " + webtoonDataArrayList.get(i));
//            }
        } else if (mParam1 === "Sale") {
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10871_1648016636.5223.jpg"
            rankingWebtoonData!!.title = "??????:????????? ????????????"
            rankingWebtoonData!!.sub_title = "???98???"
            rankingWebtoonData!!.hit = "5???"
            rankingWebtoonData!!.rank = "1???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10174_1545109436.0006.jpg"
            rankingWebtoonData!!.title = "?????? ??????"
            rankingWebtoonData!!.sub_title = "???50???-??? ?????? ??? ?????? ???????"
            rankingWebtoonData!!.hit = "1,047???"
            rankingWebtoonData!!.rank = "2???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10450_1582881801.935.jpg"
            rankingWebtoonData!!.title = "??????:???"
            rankingWebtoonData!!.sub_title = "???63??? ?????????-????????? ???????????????"
            rankingWebtoonData!!.hit = "21???"
            rankingWebtoonData!!.rank = "3???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/2631_1550797351.4803.jpg"
            rankingWebtoonData!!.title = "?????????K"
            rankingWebtoonData!!.sub_title = "??????2 ???149??? ?????????-?????? ??? ???????????? ??????"
            rankingWebtoonData!!.hit = "3,436???"
            rankingWebtoonData!!.rank = "4???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10818_1644220372.3696.jpg"
            rankingWebtoonData!!.title = "??????????????? ?????????"
            rankingWebtoonData!!.sub_title = "???46???"
            rankingWebtoonData!!.hit = "5???"
            rankingWebtoonData!!.rank = "5???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10663_1625193390.5776.jpg"
            rankingWebtoonData!!.title = "????????? ????????????"
            rankingWebtoonData!!.sub_title = "???194???"
            rankingWebtoonData!!.hit = "46???"
            rankingWebtoonData!!.rank = "6???"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)

//            for(int i=0; i<webtoonDataArrayList.size(); i ++) {
//                Log.e("RankingAdapter", "RankingAdapterListItem = " + webtoonDataArrayList.get(i));
//            }
        }
        adapter = RankingRecyclerViewAdapter(rankingWebtoonDataArrayList, requireActivity())
        recyclerView!!.adapter = adapter
    }

    companion object {
        // ???????????? ?????? ???
        private const val ARG_PARAM1 = "type"
        fun newInstance(param1: String?): RankingFragment {
            val fragment = RankingFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }
}