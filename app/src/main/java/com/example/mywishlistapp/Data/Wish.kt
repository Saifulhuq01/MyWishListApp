package com.example.mywishlistapp.Data

data class Wish(
    val id: Long = 0L,
    val title : String = "",
    val description : String = ""
)

object DummyWish{
    val WishList = listOf(
        Wish(title = "pixel" , description = "hello boys")
    )
}