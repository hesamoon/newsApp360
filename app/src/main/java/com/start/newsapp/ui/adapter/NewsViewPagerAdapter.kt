package com.start.newsapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.start.newsapp.ui.fragment.news.news_fragments.EuropeNewsFragment
import com.start.newsapp.ui.fragment.news.news_fragments.IranNewsFragment
import com.start.newsapp.ui.fragment.news.news_fragments.KharejiNewsFragment

class NewsViewPagerAdapter(fm: Fragment): FragmentStateAdapter(fm) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> IranNewsFragment()
            1 -> KharejiNewsFragment()
            2 -> EuropeNewsFragment()
            else -> IranNewsFragment()
        }
    }
}