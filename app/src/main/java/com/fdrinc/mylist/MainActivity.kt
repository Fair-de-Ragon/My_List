package com.fdrinc.mylist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager
    lateinit var addButton: ImageButton
    lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = MainActions.adapter
        recyclerView.adapter = adapter

        addButton = findViewById(R.id.add_button)
        val addActivity = Intent(this@MainActivity, AddNewCellActivity::class.java)
        addButton.setOnClickListener { startActivity(addActivity) }
    }
}