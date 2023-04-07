package com.fdrinc.mylist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager
    lateinit var addButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("phoneRepo", Context.MODE_PRIVATE)

        MainActions.getSharedPreferences(sharedPreferences)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = MainActions.adapter
        recyclerView.adapter = adapter

        val moreInfoActivity = Intent(this@MainActivity, MoreInfoActivity::class.java)
        val addNewCellActivity = Intent(this@MainActivity, AddNewCellActivity::class.java)

        addButton = findViewById(R.id.add_button)
        addButton.setOnClickListener { startActivity(addNewCellActivity) }


        adapter.goToMoreInfo = {
            moreInfoActivity.putExtra("nameOfProduct", MainActions.listRepo[it].nameOfProduct)
            moreInfoActivity.putExtra("whereToBuy", MainActions.listRepo[it].whereToBuy)
            moreInfoActivity.putExtra("description", MainActions.listRepo[it].description)
            moreInfoActivity.putExtra("position", it)
            startActivity(moreInfoActivity)
        }

        val callback: ItemTouchHelper.Callback = TouchHelperCallback(adapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerView)

    }
}