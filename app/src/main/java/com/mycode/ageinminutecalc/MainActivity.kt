package com.mycode.ageinminutecalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate : TextView? = null
    private var tvDateInMin : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickButton: Button = findViewById(R.id.button2)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvDateInMin = findViewById(R.id.tvDateInMin)
//        clickButton.setOnClickListener{
//            Toast.makeText(this,"clickButton pressed", Toast.LENGTH_LONG).show()
//        }
        clickButton.setOnClickListener{
            clickOnButton()
        }
    }

    private fun clickOnButton(){

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener{ _, selectedYear, selectedMonth, selectedDayOfMonth ->

            Toast.makeText(this,
                "date was $selectedDayOfMonth, month was ${selectedMonth+1}th & year was $selectedYear", Toast.LENGTH_LONG).show()

            val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
            tvSelectedDate?.text = selectedDate
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val date = sdf.parse(selectedDate)

            date?.let {
                val selectedDateInMin = date.time / (1000*60)
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                currentDate?.let {
                    val currentDateInMin = currentDate.time / (1000*60)
                    val differenceInMin = currentDateInMin - selectedDateInMin
                    tvDateInMin?.text = differenceInMin.toString()
                }

            }
        },
            year, month, day)

        dpd.datePicker.maxDate = System.currentTimeMillis() - (1*24*60*60*1000)
        dpd.show()

    }

}


