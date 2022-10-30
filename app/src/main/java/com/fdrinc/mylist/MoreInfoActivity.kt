package com.fdrinc.mylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class MoreInfoActivity : AppCompatActivity() {

    private lateinit var doneButton: Button
    private lateinit var nameInput: EditText
    private lateinit var whereToBuyInput: EditText
    private lateinit var descriptionInput: EditText
    private lateinit var remakeButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)

        doneButton = findViewById(R.id.more_info_done)
        nameInput = findViewById(R.id.name_more_info)
        whereToBuyInput = findViewById(R.id.where_to_buy_more_info)
        descriptionInput = findViewById(R.id.description_more_info)
        remakeButton = findViewById(R.id.more_info_remake)


    }
}