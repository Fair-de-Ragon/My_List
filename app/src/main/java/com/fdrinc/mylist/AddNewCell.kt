package com.fdrinc.mylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class AddNewCell : AppCompatActivity() {

    private lateinit var doneButton: Button
    private lateinit var nameInput: EditText
    private lateinit var whereToBuyInput: EditText
    private lateinit var descriptionInput: EditText
    private lateinit var exceptionText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_cell)

        doneButton = findViewById(R.id.done_button)
        nameInput = findViewById(R.id.name_info)
        whereToBuyInput = findViewById(R.id.where_to_buy_info)
        descriptionInput = findViewById(R.id.description_info)
        exceptionText = findViewById(R.id.exeption_text)

        doneButton.setOnClickListener {
            if (MainActions.addCell(
                    nameInput.editableText.toString(),
                    whereToBuyInput.editableText.toString(),
                    descriptionInput.editableText.toString()
                )) onBackPressed()
            else exceptionText.setText(R.string.exception)
        }
    }


}