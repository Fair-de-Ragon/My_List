package com.fdrinc.mylist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class AddNewCell : AppCompatActivity() {

    lateinit var doneButton: Button
    lateinit var nameInput: EditText
    lateinit var whereToBuyInput: EditText
    lateinit var descriptionInput: EditText
    lateinit var exceptionText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_cell)

        doneButton = findViewById(R.id.done_button)
        nameInput = findViewById(R.id.name_info)
        whereToBuyInput = findViewById(R.id.where_to_buy_info)
        descriptionInput = findViewById(R.id.description_info)
        exceptionText = findViewById(R.id.exeption_text)

        doneButton.setOnClickListener {
            if (nameInput.editableText.isNotEmpty() && whereToBuyInput.editableText.isNotEmpty() && exceptionText.editableText.isNotEmpty()) {
                MainActions.addCell(
                    nameInput.editableText.toString(),
                    whereToBuyInput.editableText.toString(),
                    descriptionInput.editableText.toString()
                )
                onBackPressed()
            } else exceptionText.setText(R.string.exception)
        }
    }


}