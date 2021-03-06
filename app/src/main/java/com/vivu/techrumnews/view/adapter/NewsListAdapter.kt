package com.vivu.techrumnews.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vivu.techrumnews.R
import com.vivu.techrumnews.model.NewsModel
import com.vivu.techrumnews.view.NewsInterface
import java.util.ArrayList

class NewsListAdapter(context: Context, inf: NewsInterface) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var subContext = context
    var dataList = ArrayList<NewsModel>()
    var view = inf

    var NEWS_TYPE = 1
    var ADS_TYPE = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var inflateView = LayoutInflater.from(subContext).inflate(R.layout.item_news, parent, false)
        when (viewType) {
            NEWS_TYPE -> {
                inflateView = LayoutInflater.from(subContext).inflate(R.layout.item_news, parent, false)
                return ViewHolder(inflateView)
            }

            ADS_TYPE -> {
                inflateView = LayoutInflater.from(subContext).inflate(R.layout.item_news, parent, false)
                return AdsViewHolder(inflateView)
            }
        }
        return ViewHolder(inflateView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (dataList[position].isAds) {
            ADS_TYPE
        } else {
            NEWS_TYPE
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val data = dataList[position]
                holder.setData(data)
            }

            is AdsViewHolder -> {
                //Init Ads
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv_author_news: TextView = itemView.findViewById(R.id.tv_author_news)
        var tv_title_news: TextView = itemView.findViewById(R.id.tv_title_news)

        fun setData(model: NewsModel) {
            tv_author_news.text = model.author
            tv_title_news.text = model.title
        }
    }

    class AdsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(model: NewsModel) {

        }
    }
}