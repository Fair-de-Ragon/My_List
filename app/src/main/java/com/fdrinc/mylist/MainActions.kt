package com.fdrinc.mylist

import android.widget.Toast

object MainActions {

    private val adapter: ListAdapter = ListAdapter()
    var listRepo = mutableListOf<CellType>()

    fun addFirst(){
        listRepo.add(CellType("Молоко", "Магнит", "10%"))
    }

    fun deleteCell(id: Int) {
        listRepo.removeAt(id)
        adapter.updateData(listRepo)
    }

    fun addCell(name: String, whereToBuy: String, description: String): Boolean {
        return if (name.isNotEmpty() && whereToBuy.isNotEmpty() && description.isNotEmpty()) {
            val newCell = CellType(name, whereToBuy, description)
            listRepo.add(newCell)
            adapter.updateData(listRepo)
            true
        } else false
    }

//    fun refactorCell(index: Int, remakeCell: CellType) {
//        listRepo[index] = remakeCell
//        adapter.updateData(listRepo)
//    }

}