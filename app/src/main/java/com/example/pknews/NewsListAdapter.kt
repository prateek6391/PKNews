package com.example.pknews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsListAdapter(private val items:ArrayList<String>, private val listener: NewsItemClicked): RecyclerView.Adapter<NewsViewHolder>() {
//  Here we implement 3 function
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        val viewHolder = NewsViewHolder(view)
        // handle item clicks
        view.setOnClickListener{
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    //  Here we take holder and bind with current item
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem
    }

//  Here we suggest size
    override fun getItemCount(): Int {
        return items.size
    }
}

//  viewHolder class for adapter
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)    {
    // item which inflate again and again
    val titleView: TextView = itemView.findViewById((R.id.title))
}

// create callback from adapter to activity for onClickListener (for this we use interfaces)
interface NewsItemClicked{
    fun onItemClicked(item: String)
}
