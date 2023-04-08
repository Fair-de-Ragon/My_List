package com.fdrinc.mylist

import android.content.SharedPreferences

object MainActions: SharedPref() {

    var adapter: ListAdapter = ListAdapter()
    var listRepo = mutableListOf<CellType>()
    lateinit var sharedPreferencesInRepo: SharedPreferences

    fun addFirst() {
        listRepo.add(CellType("Молоко", "Магнит", "10%", false))
        adapter.hardUpdate(listRepo)
        updateSharedPreferences(sharedPreferencesInRepo)
    }

    fun deleteCell(position: Int) {
        listRepo.removeAt(position)
        adapter.deleteCell(position)
        updateSharedPreferences(sharedPreferencesInRepo)
    }

    fun addCell(name: String, whereToBuy: String, description: String): Boolean {
        return if (name.isNotEmpty() && whereToBuy.isNotEmpty() && description.isNotEmpty()) {
            val newCell = CellType(name, whereToBuy, description, true)
            listRepo.add(newCell)
            adapter.insertData()
            updateSharedPreferences(sharedPreferencesInRepo)
            true
        } else false
    }

    fun remakeCell(name: String, whereToBuy: String, description: String, position: Int): Boolean {
        return if (name.isNotEmpty() && whereToBuy.isNotEmpty() && description.isNotEmpty()) {
            val modifiedCell = CellType(name, whereToBuy, description, listRepo[position].isActive)
            listRepo[position] = modifiedCell
            adapter.softUpdate(position)
            true
        } else false
    }

    fun swipeElements(firstIndex: Int, secondIndex: Int) {
        val firstEl = listRepo[firstIndex]
        val secondEl = listRepo[secondIndex]
        listRepo[firstIndex] = secondEl
        listRepo[secondIndex] = firstEl
    }
}