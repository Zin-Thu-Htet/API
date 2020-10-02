package com.example.api.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api.R
import com.example.api.adapter.NewsAdapter
import com.example.api.model.ArticlesItem
import com.example.api.viewmodel.HomeViewmodel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var homeViewmodel = ViewModelProvider(this)
            .get(HomeViewmodel::class.java)

        var newsAdapter = NewsAdapter()

        newRecycler.layoutManager = LinearLayoutManager(context)
        newRecycler.adapter = newsAdapter

        homeViewmodel.loadArticle()

        homeViewmodel.getArticle().observe(
            viewLifecycleOwner, Observer { news->
                newsAdapter.updateArticle(news.articles as List<ArticlesItem>)
            }
        )
    }

}