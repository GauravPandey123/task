package com.swipewcards.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swipewcards.R
import com.swipewcards.model.StackHolder
import com.swipewcards.áctivity.DeatilsActivity

class CardStackAdapter(
    private val context: Context,
    private var stackholder: List<StackHolder> = emptyList()
) :
    RecyclerView.Adapter<CardStackAdapter.CardStackViewHolder>() {


    private  var position: Int = 0

    inner class CardStackViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imageViewBackGroundImageView =
            view.findViewById<ImageView>(R.id.profile_photo)
        val textViewCardStackTitle = view.findViewById<TextView>(R.id.textViewCardStackTitle)
        val textViewAddress = view.findViewById<TextView>(R.id.textViewAddress)
        val imageViewCall = view.findViewById<ImageView>(R.id.imageViewCall)
        val imageViewCalendra = view.findViewById<ImageView>(R.id.imageViewCalendra)
        val imageViewMap = view.findViewById<ImageView>(R.id.imageViewMap)
        val imageViewPassword = view.findViewById<ImageView>(R.id.imageViewPassword)
        val itemViewCard = view.findViewById<CardView>(R.id.itemViewCard)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardStackViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_stack_item, parent, false)
        return CardStackViewHolder(view)

    }

    override fun onBindViewHolder(holder: CardStackViewHolder, position: Int) {
        this.position =position
        val stackholder = stackholder[position]
        holder.textViewAddress.text = stackholder.city
        Glide.with(context)
            .load(stackholder.url).circleCrop()
            .into(holder.imageViewBackGroundImageView)


    }

    fun setSpots(spots: List<StackHolder>) {
        this.stackholder = spots
    }

    fun getSpots(): List<StackHolder> {
        return stackholder
    }

    fun getpostion(position : Int){
        this.position =position
    }
    override fun getItemCount(): Int {
        return stackholder.size
    }
}