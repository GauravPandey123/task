package com.swipewcards.model

import java.io.Serializable

data class StackHolder(
    val id: Long = counter++,
    val name: String,
    val city: String,
    val url: String
) : Serializable {
    companion object {
        private var counter = 0L
    }
}
