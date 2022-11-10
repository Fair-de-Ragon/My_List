package com.fdrinc.mylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
    private lateinit var exceptionText: TextView
    private lateinit var intentExtras: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)

         val intentExtras = intent.extras

        doneButton = findViewById(R.id.more_info_done)
        nameInput = findViewById(R.id.name_more_info)
        whereToBuyInput = findViewById(R.id.where_to_buy_more_info)
        descriptionInput = findViewById(R.id.description_more_info)
        remakeButton = findViewById(R.id.more_info_remake)
        /**TODO change id after deleting AddNewCellActivity*/
        exceptionText = findViewById(R.id.exeption_text2)

        if ( intentExtras != null) {
            nameInput.setText(intentExtras.get("nameOfProduct").toString())
            nameInput.isEnabled = false
            whereToBuyInput.setText(intentExtras.get("whereToBuy").toString())
            whereToBuyInput.isEnabled = false
            descriptionInput.setText(intentExtras.get("description").toString())
            descriptionInput.isEnabled = false
        }

        remakeButton.setOnClickListener { lockUnlockFields() }
    }

    private fun lockUnlockFields() {
        nameInput.isEnabled = !nameInput.isEnabled
        whereToBuyInput.isEnabled = !whereToBuyInput.isEnabled
        descriptionInput.isEnabled = !descriptionInput.isEnabled
    }
}