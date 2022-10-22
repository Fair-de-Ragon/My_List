package com.fdrinc.mylist

object MainActions {

    private val adapter: ListAdapter = ListAdapter()
    var listRepo = mutableListOf<CellType>()

    fun addFirst(){
        listRepo.add(CellType("Молоко", "Магнит", "10%"))
        adapter.setData(listRepo)
    }

    fun deleteCell(id: Int) {
        listRepo.removeAt(id)
        adapter.insertData(listRepo)
    }

    fun addCell(name: String, whereToBuy: String, description: String): Boolean {
        return if (name.isNotEmpty() && whereToBuy.isNotEmpty() && description.isNotEmpty()) {
            val newCell = CellType(name, whereToBuy, description)
            listRepo.add(newCell)
            adapter.insertData(listRepo)
            true
        } else false
    }

//    fun refactorCell(index: Int, remakeCell: CellType) {
//        listRepo[index] = remakeCell
//        adapter.updateData(listRepo)
//    }

}