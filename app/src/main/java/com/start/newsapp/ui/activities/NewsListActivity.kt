package com.start.newsapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.start.newsapp.R
import com.start.newsapp.model.football_model.PostModel
import com.start.newsapp.ui.fragment.NewsDetailFragment
import com.start.newsapp.ui.listener.NewsListInterface
import kotlinx.android.synthetic.main.activity_news_list.*

class NewsListActivity: AppCompatActivity(), NewsListInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        setRecyclerViewData()
    }

    private fun setRecyclerViewData() {
        recycler_view.layoutManager =
            LinearLayoutManager(this@NewsListActivity, RecyclerView.VERTICAL, false)

//        recycler_view.adapter = NewsListAdapter(DummyData().newsListSample, this@NewsListActivity)
    }

    override fun onNewsItemClicked(news_item: PostModel) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, NewsDetailFragment.getNewsDetailFragment(news_item))
            .addToBackStack(null)
            .commit()
    }
}