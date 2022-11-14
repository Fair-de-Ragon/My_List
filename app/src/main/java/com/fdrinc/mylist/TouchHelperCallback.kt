package com.fdrinc.mylist

import android.graphics.Canvas
import android.os.Parcel
import android.os.Parcelable
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class TouchHelperCallback() : ItemTouchHelper.Callback(), Parcelable {

    private var mAdapter: ItemTouchHelperAdapter? = null

    constructor(parcel: Parcel) : this() {

    }

    constructor(adapter: ItemTouchHelperAdapter) : this() { mAdapter = adapter }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlags = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        mAdapter?.onItemMove(viewHolder.adapterPosition, target.adapterPosition);
        return true;
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (direction == ItemTouchHelper.LEFT) {
            mAdapter?.onItemSwipeLeft(viewHolder.adapterPosition);
        } else {
            mAdapter?.onItemSwipeRight(viewHolder.adapterPosition)
        }
    }


    override fun isLongPressDragEnabled(): Boolean {
        return true
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TouchHelperCallback> {
        override fun createFromParcel(parcel: Parcel): TouchHelperCallback {
            return TouchHelperCallback(parcel)
        }

        override fun newArray(size: Int): Array<TouchHelperCallback?> {
            return arrayOfNulls(size)
        }
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            when (dX) {
                in 0f..500f -> viewHolder.itemView.translationX = dX / 2
                in -500f..0f -> viewHolder.itemView.translationX = dX / 2
            }
        } else {
            super.onChildDraw(
                c,
                recyclerView,
                viewHolder,
                dX,
                dY,
                actionState,
                isCurrentlyActive
            )
        }
    }
}