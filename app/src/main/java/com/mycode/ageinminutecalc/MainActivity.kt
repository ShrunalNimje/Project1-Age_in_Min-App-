package com.mycode.ageinminutecalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickButton: Button = findViewById(R.id.button2)
//        clickButton.setOnClickListener{
//            Toast.makeText(this,"clickButton pressed", Toast.LENGTH_LONG).show()
//        }
        clickButton.setOnClickListener{
            clickOnButton()
        }
    }

    fun clickOnButton(){

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->

            Toast.makeText(this,
                "clickButton pressed", Toast.LENGTH_LONG).show()
        },

            year, month, day).show()
    }

}


