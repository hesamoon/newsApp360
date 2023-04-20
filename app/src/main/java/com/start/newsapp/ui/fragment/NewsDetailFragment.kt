package com.start.newsapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import coil.load
import com.start.newsapp.R
import com.start.newsapp.model.football_model.PostModel
import kotlinx.android.synthetic.main.fragment_news_detail.*

class NewsDetailFragment: Fragment(R.layout.fragment_news_detail), View.OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_news_detail_title.text = newsDetailItem?.title
        tv_news_detail_description.text = newsDetailItem?.body
        tv_news_detail_author.text = newsDetailItem?.author
        iv_news_detail_cover.load(newsDetailItem?.cover)
        iv_news_detail_back.setOnClickListener(this)
    }

    companion object{
        var newsDetailItem: PostModel? = null
        fun getNewsDetailFragment(item: PostModel): NewsDetailFragment{
            newsDetailItem = item
            return NewsDetailFragment()
        }
    }

    override fun onClick(v: View?) {
        when(v){
            iv_news_detail_back -> activity?.onBackPressed()
        }
    }
}