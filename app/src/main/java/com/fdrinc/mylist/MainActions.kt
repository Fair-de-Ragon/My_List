package com.fdrinc.mylist

object MainActions {

    var adapter: ListAdapter = ListAdapter()
    var listRepo = mutableListOf<CellType>()

    fun addFirst() {
        listRepo.add(CellType("Молоко", "Магнит", "10%"))
        adapter.hardUpdate(listRepo)
    }

    fun deleteCell(position: Int) {
        listRepo.removeAt(position)
        adapter.deleteCell(position)
    }

    fun addCell(name: String, whereToBuy: String, description: String): Boolean {
        return if (name.isNotEmpty() && whereToBuy.isNotEmpty() && description.isNotEmpty()) {
            val newCell = CellType(name, whereToBuy, description)
            listRepo.add(newCell)
            adapter.insertData()
            true
        } else false
    }
}