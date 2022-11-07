package com.fdrinc.mylist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fdrinc.mylist.MainActions.adapter

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager
    lateinit var addButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainActions.addFirst()

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = MainActions.adapter
        recyclerView.adapter = adapter

        addButton = findViewById(R.id.add_button)
        val addActivity = Intent(this@MainActivity, AddNewCellActivity::class.java)
        addButton.setOnClickListener { startActivity(addActivity) }


        adapter.goToMoreInfo = {
            val moreInfoActivity = Intent(this@MainActivity, MoreInfoActivity::class.java)
            moreInfoActivity.putExtra("nameOfProduct", MainActions.listRepo[it].nameOfProduct)
            moreInfoActivity.putExtra("whereToBuy", MainActions.listRepo[it].whereToBuy)
            moreInfoActivity.putExtra("description", MainActions.listRepo[it].description)
            moreInfoActivity.putExtra("position", it)
            startActivity(moreInfoActivity)
        }
    }
}