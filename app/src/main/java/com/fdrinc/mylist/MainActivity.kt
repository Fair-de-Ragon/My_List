package com.fdrinc.mylist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager
    lateinit var addButton: ImageButton
    lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainActions.addFirst()

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        //recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = ListAdapter()
        recyclerView.adapter = adapter

        addButton = findViewById(R.id.add_button)
        val addActivity = Intent(this@MainActivity, AddNewCell::class.java)
        addButton.setOnClickListener { startActivity(addActivity) }
    }

    override fun onResume() {
        super.onResume()
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        //recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = ListAdapter()
        recyclerView.adapter = adapter

        addButton = findViewById(R.id.add_button)
        val addActivity = Intent(this@MainActivity, AddNewCell::class.java)
        addButton.setOnClickListener { startActivity(addActivity)}
    }
}