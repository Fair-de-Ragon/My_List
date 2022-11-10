package com.fdrinc.mylist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView


class ListAdapter: RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var cellList = MainActions.listRepo

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameCellText: TextView = itemView.findViewById(R.id.nameCell)
        val whereToBuyText: TextView = itemView.findViewById(R.id.whereToBuy)
        val descriptionText: TextView = itemView.findViewById(R.id.description)
        val item: CardView = itemView.findViewById(R.id.one_item)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun hardUpdate(newData: MutableList<CellType>) {
        cellList = newData
        notifyDataSetChanged()
    }

    fun insertData() {
        notifyItemInserted(cellList.size - 1)
    }

    fun deleteCell(position: Int) {
        notifyItemRemoved(position)
    }

    fun softUpdate(position: Int) {
        notifyItemChanged(position)
    }

    var goToMoreInfo: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layout = when (viewType){
            ITEM_ENABLED -> R.layout.item_enabled_layout
            ITEM_DISABLED -> R.layout.item_disabled_layout
            else -> throw RuntimeException("Unknown viewType: $viewType")
        }
        val itemView =
            LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.nameCellText.text = cellList[position].nameOfProduct
        holder.whereToBuyText.text = cellList[position].whereToBuy
        holder.descriptionText.text = cellList[position].description
        holder.item.setOnClickListener{
            cellList[position].isActive = !cellList[position].isActive
            softUpdate(position)
        }
        holder.item.setOnLongClickListener {
            goToMoreInfo?.invoke(position)
            softUpdate(position)
            true
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (cellList[position].isActive) {
            true -> ITEM_ENABLED
            false -> ITEM_DISABLED
            else -> ITEM_ENABLED
        }
    }

    override fun getItemCount(): Int {
        return if (cellList == null) 0 else cellList.size
    }

    companion object {
        const val ITEM_ENABLED = 11
        const val ITEM_DISABLED = 10
    }
}