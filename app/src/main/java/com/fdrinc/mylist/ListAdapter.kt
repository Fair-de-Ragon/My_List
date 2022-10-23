package com.fdrinc.mylist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter: RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var cellList: MutableList<CellType> = MainActions.listRepo

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameCellText: TextView = itemView.findViewById(R.id.nameCell)
        val whereToBuyText: TextView = itemView.findViewById(R.id.whereToBuy)
        val descriptionText: TextView = itemView.findViewById(R.id.description)
        val deleteButton: ImageButton = itemView.findViewById(R.id.delete_button)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: MutableList<CellType>) {
        cellList = list
        notifyDataSetChanged()
    }

    fun insertData() {
        notifyItemInserted(cellList.size - 1)
    }

    fun deleteCell(position: Int) {
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.nameCellText.text = cellList[position].nameOfProduct
        holder.whereToBuyText.text = cellList[position].whereToBuy
        holder.descriptionText.text = cellList[position].description
        holder.deleteButton.setOnClickListener { MainActions.deleteCell(position) }
    }

    override fun getItemCount() = cellList.size
}