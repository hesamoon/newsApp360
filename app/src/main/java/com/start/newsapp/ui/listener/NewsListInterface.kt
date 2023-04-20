package com.start.newsapp.ui.listener

import com.start.newsapp.model.football_model.PostModel


interface NewsListInterface {
    fun onNewsItemClicked(news_item: PostModel)
}