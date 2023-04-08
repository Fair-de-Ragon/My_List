package com.fdrinc.mylist

import android.content.SharedPreferences
import java.lang.StringBuilder

open class SharedPref {
    fun updateSharedPreferences (sharedPreferences: SharedPreferences){
        val st = StringBuilder()
        for (cellType in MainActions.listRepo) {
            st.append(cellType.nameOfProduct + "/" + cellType.whereToBuy + "/" + cellType.description + "/" + cellType.isActive + "[]")
        }
        sharedPreferences.edit().putString("listRepo", st.toString()).apply()
    }

    fun getSharedPreferences (sharedPreferences: SharedPreferences){
        MainActions.sharedPreferencesInRepo = sharedPreferences
        val gotString = sharedPreferences.getString("listRepo", null)
        if (gotString != null) {
            val collectionOfStringCellType: List<String> = gotString.split("[]")
            for (stringCellType in collectionOfStringCellType.dropLast(1)) {
                val listOfParam = stringCellType.split("/")
                val cellType = CellType(
                    listOfParam[0],
                    listOfParam[1],
                    listOfParam[2],
                    listOfParam[3].equals("true"))
                MainActions.listRepo.add(cellType)
                MainActions.adapter.hardUpdate(MainActions.listRepo)
            }
        } else MainActions.addFirst()
    }
}