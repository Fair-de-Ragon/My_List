package com.fdrinc.mylist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter: RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var cellList: MutableList<CellType> = MainActions.listRepo

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameCellText: TextView = itemView.findViewById(R.id.nameCell)
        val whereToBuyText: TextView = itemView.findViewById(R.id.whereToBuy)
        val descriptionText: TextView = itemView.findViewById(R.id.description)
        val deleteButton: Button = itemView.findViewById(R.id.delete_button)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(updatedList: MutableList<CellType>) {
        cellList.clear()
        cellList.addAll(updatedList)

        notifyDataSetChanged()
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
        holder.deleteButton.setOnClickListener { MainActions.deleteCell(this.itemCount) }
    }

    override fun getItemCount() = cellList.size
}