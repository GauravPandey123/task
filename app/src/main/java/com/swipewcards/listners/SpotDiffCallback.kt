package com.swipewcards.listners

import androidx.recyclerview.widget.DiffUtil
import com.swipewcards.model.StackHolder

class SpotDiffCallback(
        private val old: List<StackHolder>,
        private val new: List<StackHolder>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition].id == new[newPosition].id
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition] == new[newPosition]
    }

}
