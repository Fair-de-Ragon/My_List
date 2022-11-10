package com.fdrinc.mylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class AddNewCellActivity : AppCompatActivity() {

    private lateinit var doneButton: Button
    private lateinit var nameInput: EditText
    private lateinit var whereToBuyInput: EditText
    private lateinit var descriptionInput: EditText
    private lateinit var exceptionText: TextView
    private lateinit var remakeButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)

        doneButton = findViewById(R.id.more_info_done)
        nameInput = findViewById(R.id.name_more_info)
        whereToBuyInput = findViewById(R.id.where_to_buy_more_info)
        descriptionInput = findViewById(R.id.description_more_info)
        remakeButton = findViewById(R.id.more_info_remake)
        /**TODO change id after deleting AddNewCellActivity*/
        exceptionText = findViewById(R.id.exeption_text2)

        remakeButton.visibility = View.GONE
        nameInput.isEnabled = true
        whereToBuyInput.isEnabled = true
        descriptionInput.isEnabled = true

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