package com.mws.mwskuis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_quotes.view.*

class QuotesAdapter (private val list: ArrayList<QuotesResponse>): RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder>(){
    inner class QuotesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(quotesResponse: QuotesResponse){
            with(itemView){
                val text = "text : ${quotesResponse.text}\n" +
                        "author : ${quotesResponse.author}"
                txtList.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_quotes,parent,false)
        return QuotesViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
       holder.bind(list[position])
    }
}
