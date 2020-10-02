package com.swipewcards.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swipewcards.R
import com.swipewcards.model.StackHolder
import com.swipewcards.áctivity.DeatilsActivity

class FavoirteAdapter(val context: Context,  private var stackholder: List<StackHolder> = emptyList()) :
    RecyclerView.Adapter<FavoirteAdapter.FaviorteViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaviorteViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cardview_item,parent,false)
        return FaviorteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FaviorteViewHolder, position: Int) {
        val stackholder = stackholder[position]
        holder.location.text = stackholder.city
        Glide.with(context)
            .load(stackholder.url).circleCrop()
            .into(holder.imageView)

        holder.textView.text = stackholder.name



    }

    override fun getItemCount(): Int {
        return stackholder.size
    }




    inner class FaviorteViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val textView = view.findViewById<TextView>(R.id.textView)
        val location = view.findViewById<TextView>(R.id.location)
    }


}