package com.start.newsapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.start.newsapp.R
import com.start.newsapp.model.football_model.PostModel
import com.start.newsapp.ui.listener.NewsListInterface
import kotlinx.android.synthetic.main.item_news_list.view.*

class NewsListAdapter(private val newsListItems: List<PostModel>, val listener: NewsListInterface):
    RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder>() {

    inner class NewsListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindData(item: PostModel, listener: NewsListInterface){
            itemView.tv_title.text = item.title
            itemView.tv_description.text = item.body
            itemView.iv_news_cover.load(item.cover)
            itemView.tv_author.text = item.author
            itemView.setOnClickListener {
                listener.onNewsItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_news_list,
                parent,
                false
            )

        return NewsListViewHolder(layout)
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.bindData(newsListItems[position], listener)
    }

    override fun getItemCount(): Int {
        return newsListItems.size
    }
}