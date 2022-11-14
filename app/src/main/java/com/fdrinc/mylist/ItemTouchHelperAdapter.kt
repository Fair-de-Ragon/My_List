package com.fdrinc.mylist

interface ItemTouchHelperAdapter {
    fun onItemMove(fromPosition: Int, toPosition: Int)

    fun onItemSwipeLeft(position: Int)

    fun onItemSwipeRight(position: Int)
}