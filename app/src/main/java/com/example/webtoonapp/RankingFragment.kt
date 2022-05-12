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
            rankingWebtoonData!!.title = "편의점 샛별이"
            rankingWebtoonData!!.sub_title = "제67화 최종화-영업종료"
            rankingWebtoonData!!.hit = "5,803만"
            rankingWebtoonData!!.rank = "1위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10291_1558085744.1762.jpg"
            rankingWebtoonData!!.title = "사각사각 로맨스"
            rankingWebtoonData!!.sub_title = "제168화-처음 보는 남자친구의 표정"
            rankingWebtoonData!!.hit = "1,942만"
            rankingWebtoonData!!.rank = "2위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10415_1591248416.2574.jpg"
            rankingWebtoonData!!.title = "H-mate"
            rankingWebtoonData!!.sub_title = "제75화 최종화-해피엔딩"
            rankingWebtoonData!!.hit = "46만"
            rankingWebtoonData!!.rank = "3위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10609_1619599386.7538.jpg"
            rankingWebtoonData!!.title = "대표님, 사모님이 도망가요"
            rankingWebtoonData!!.sub_title = "제289화 최종화"
            rankingWebtoonData!!.hit = "48만"
            rankingWebtoonData!!.rank = "4위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10586_1614672726.6089.jpg"
            rankingWebtoonData!!.title = "신데렐라의 역습"
            rankingWebtoonData!!.sub_title = "시즌1 최종화"
            rankingWebtoonData!!.hit = "6.5만"
            rankingWebtoonData!!.rank = "5위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10340_1566267954.1921.jpg"
            rankingWebtoonData!!.title = "블러디 발렌타인:인류종말"
            rankingWebtoonData!!.sub_title = "제412화"
            rankingWebtoonData!!.hit = "11만"
            rankingWebtoonData!!.rank = "6위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)

//            for(int i=0; i<webtoonDataArrayList.size(); i ++) {
//                Log.e("RankingAdapter", "RankingAdapterListItem = " + webtoonDataArrayList.get(i));
//            }
        } else if (mParam1 === "Update") {
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10828_1645411050.2519.jpg"
            rankingWebtoonData!!.title = "신무천존"
            rankingWebtoonData!!.sub_title = "제134화"
            rankingWebtoonData!!.hit = "5천"
            rankingWebtoonData!!.rank = "1위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10568_1604900784.8631.jpg"
            rankingWebtoonData!!.title = "속도위반 대표님과 계약 아내"
            rankingWebtoonData!!.sub_title = "제410화"
            rankingWebtoonData!!.hit = "95만"
            rankingWebtoonData!!.rank = "2위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10859_1646896306.4209.jpg"
            rankingWebtoonData!!.title = "불순한 동거동락"
            rankingWebtoonData!!.sub_title = "제80화 최종화"
            rankingWebtoonData!!.hit = "5천"
            rankingWebtoonData!!.rank = "3위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10815_1644219619.8057.jpg"
            rankingWebtoonData!!.title = "폭군의 눈물"
            rankingWebtoonData!!.sub_title = "제47화"
            rankingWebtoonData!!.hit = "5천"
            rankingWebtoonData!!.rank = "4위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10532_1596439274.1639.jpg"
            rankingWebtoonData!!.title = "대표님 책임지세요"
            rankingWebtoonData!!.sub_title = "제207화"
            rankingWebtoonData!!.hit = "29만"
            rankingWebtoonData!!.rank = "5위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10830_1645410926.1581.jpg"
            rankingWebtoonData!!.title = "무적검역"
            rankingWebtoonData!!.sub_title = "제94화"
            rankingWebtoonData!!.hit = "5천"
            rankingWebtoonData!!.rank = "6위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)

//            for(int i=0; i<webtoonDataArrayList.size(); i ++) {
//                Log.e("RankingAdapter", "RankingAdapterListItem = " + webtoonDataArrayList.get(i));
//            }
        } else if (mParam1 === "New") {
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10848_1646639017.4464.jpg"
            rankingWebtoonData!!.title = "말단 병사에서 군주까지"
            rankingWebtoonData!!.sub_title = "제71화"
            rankingWebtoonData!!.hit = "5천"
            rankingWebtoonData!!.rank = "1위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10850_1646644712.7923.jpg"
            rankingWebtoonData!!.title = "전설 헌터로 키워지는 중입니다"
            rankingWebtoonData!!.sub_title = "제27화"
            rankingWebtoonData!!.hit = "5천"
            rankingWebtoonData!!.rank = "2위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10816_1644220013.7383.jpg"
            rankingWebtoonData!!.title = "별빛 아래 우리"
            rankingWebtoonData!!.sub_title = "제67화"
            rankingWebtoonData!!.hit = "5천"
            rankingWebtoonData!!.rank = "3위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10831_1645411113.0887.jpg"
            rankingWebtoonData!!.title = "역천 지존"
            rankingWebtoonData!!.sub_title = "제89화"
            rankingWebtoonData!!.hit = "5천"
            rankingWebtoonData!!.rank = "4위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10815_1644219619.8057.jpg"
            rankingWebtoonData!!.title = "폭군의 눈물"
            rankingWebtoonData!!.sub_title = "제47화"
            rankingWebtoonData!!.hit = "5천"
            rankingWebtoonData!!.rank = "5위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10852_1646644078.0962.jpg"
            rankingWebtoonData!!.title = "나홀로 초능력자"
            rankingWebtoonData!!.sub_title = "제32화"
            rankingWebtoonData!!.hit = "5천"
            rankingWebtoonData!!.rank = "6위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)

//            for(int i=0; i<webtoonDataArrayList.size(); i ++) {
//                Log.e("RankingAdapter", "RankingAdapterListItem = " + webtoonDataArrayList.get(i));
//            }
        } else if (mParam1 === "Sale") {
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10871_1648016636.5223.jpg"
            rankingWebtoonData!!.title = "무역:운명을 거스르다"
            rankingWebtoonData!!.sub_title = "제98화"
            rankingWebtoonData!!.hit = "5천"
            rankingWebtoonData!!.rank = "1위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10174_1545109436.0006.jpg"
            rankingWebtoonData!!.title = "동네 누나"
            rankingWebtoonData!!.sub_title = "제50화-너 지금 뭐 하는 거야?"
            rankingWebtoonData!!.hit = "1,047만"
            rankingWebtoonData!!.rank = "2위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10450_1582881801.935.jpg"
            rankingWebtoonData!!.title = "누나:연"
            rankingWebtoonData!!.sub_title = "제63화 최종화-우리는 살아남았다"
            rankingWebtoonData!!.hit = "21만"
            rankingWebtoonData!!.rank = "3위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/2631_1550797351.4803.jpg"
            rankingWebtoonData!!.title = "청소부K"
            rankingWebtoonData!!.sub_title = "시즌2 제149화 최종화-항상 널 지켜보고 있다"
            rankingWebtoonData!!.hit = "3,436만"
            rankingWebtoonData!!.rank = "4위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10818_1644220372.3696.jpg"
            rankingWebtoonData!!.title = "백스테이지 키스신"
            rankingWebtoonData!!.sub_title = "제46화"
            rankingWebtoonData!!.hit = "5천"
            rankingWebtoonData!!.rank = "5위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)
            rankingWebtoonData = RankingWebtoonData()
            rankingWebtoonData!!.img = "https://shtosebzjw.akamaized.net/assets/upfile/co_thumb4/10663_1625193390.5776.jpg"
            rankingWebtoonData!!.title = "대표님 살살해요"
            rankingWebtoonData!!.sub_title = "제194화"
            rankingWebtoonData!!.hit = "46만"
            rankingWebtoonData!!.rank = "6위"
            rankingWebtoonDataArrayList!!.add(rankingWebtoonData!!)

//            for(int i=0; i<webtoonDataArrayList.size(); i ++) {
//                Log.e("RankingAdapter", "RankingAdapterListItem = " + webtoonDataArrayList.get(i));
//            }
        }
        adapter = RankingRecyclerViewAdapter(rankingWebtoonDataArrayList, requireActivity())
        recyclerView!!.adapter = adapter
    }

    companion object {
        // 전달받은 탭의 값
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