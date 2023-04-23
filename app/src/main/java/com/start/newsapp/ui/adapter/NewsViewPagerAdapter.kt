package com.start.newsapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.start.newsapp.ui.fragment.news.news_fragments.LatestNewsFragment
import com.start.newsapp.ui.fragment.news.news_fragments.DomesticNewsFragment
import com.start.newsapp.ui.fragment.news.news_fragments.ForeignNewsFragment

class NewsViewPagerAdapter(fm: Fragment): FragmentStateAdapter(fm) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> DomesticNewsFragment()
            1 -> ForeignNewsFragment()
            2 -> LatestNewsFragment()
            else -> DomesticNewsFragment()
        }
    }
}