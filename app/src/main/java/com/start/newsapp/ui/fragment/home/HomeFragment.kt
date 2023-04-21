package com.start.newsapp.ui.fragment.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.start.newsapp.R
import com.start.newsapp.dto.football_360_model.getFootballPostModel
import com.start.newsapp.model.football_model.PostModel
import com.start.newsapp.network.RetrofitObject
import com.start.newsapp.ui.adapter.NewsListAdapter
import com.start.newsapp.ui.fragment.NewsDetailFragment
import com.start.newsapp.ui.listener.NewsListInterface
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.HttpException
import java.io.IOException

class HomeFragment: Fragment(R.layout.fragment_home), NewsListInterface {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
            progress_bar.visibility = View.VISIBLE

            val response = try{
                RetrofitObject.newsApiObject.getFootballNewsPosts("news-new")

            } catch (ioError: IOException){
                progress_bar.visibility = View.GONE
                Toast.makeText(context, ioError.toString(), Toast.LENGTH_SHORT).show()
                return@launchWhenCreated

            } catch (httpError: HttpException){
                progress_bar.visibility = View.GONE
                Toast.makeText(context, httpError.toString(), Toast.LENGTH_SHORT).show()
                return@launchWhenCreated

            }
            progress_bar.visibility = View.GONE
            if(response.isSuccessful && response.body() != null)
                setRecyclerViewData(response.body()!![2].getFootballPostModel())

            else
                Toast.makeText(context, response.errorBody().toString(), Toast.LENGTH_SHORT).show()

        }
    }

    var test = ""

    private fun setRecyclerViewData(item: List<PostModel>) {
        recycler_view.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)

        recycler_view.adapter = NewsListAdapter(
            item,
            this@HomeFragment
        )
    }

    override fun onNewsItemClicked(news_item: PostModel) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, NewsDetailFragment.getNewsDetailFragment(news_item))
            .addToBackStack(null)
            .commit()
    }
}