package com.example.api.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api.R
import com.example.api.model.ArticlesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

    private  var articlesItem : List<ArticlesItem> = ArrayList()

    class NewsViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){

        fun bind(articlesItem: ArticlesItem){
            itemView.txtTitle.text = articlesItem.title
            itemView.txtDescription.text = articlesItem.description
            Picasso.get()
                .load(articlesItem.urlToImage)
                .into(itemView.newsImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent,false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = articlesItem.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articlesItem[position])
    }

    fun updateArticle(articlesItem: List<ArticlesItem>){
        this.articlesItem = articlesItem
        notifyDataSetChanged()
    }
}