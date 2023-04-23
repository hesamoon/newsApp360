package com.start.newsapp.ui.fragment.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.start.newsapp.R
import com.start.newsapp.ui.adapter.NewsViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment: Fragment(R.layout.fragment_news) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view_pager.adapter = NewsViewPagerAdapter(this@NewsFragment)

        TabLayoutMediator(tab_layout, view_pager){ tab, position ->
            when(position){
                0 -> tab.text = "اخبار داخلی"
                1 -> tab.text = "اخبار خارجی"
                2 -> tab.text = "آخرین خبرها"
            }
        }.attach()
    }

}