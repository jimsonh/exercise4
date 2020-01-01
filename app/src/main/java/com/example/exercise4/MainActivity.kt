package com.example.exercise4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSelectDate.setOnClickListener {
            onClickDatePicker(it)
        }




    }
    private fun onClickDatePicker(view: View){

        val cal: Calendar = Calendar.getInstance()
        val currentYear = cal.get(Calendar.YEAR)
        val currentMonth = cal.get(Calendar.MONTH)
        val currentDay = cal.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
            this, onClickDatePickerListener(view, currentYear),
            currentYear, currentMonth, currentDay
        )
        datePickerDialog.show()
    }

    private fun onClickDatePickerListener(view: View, currentYear: Int) : DatePickerDialog.OnDateSetListener {
        return DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->


            val age = currentYear - year
            val minSaving = getSaving(age)


            ageTxt.text = " " + age
            savingTxt.text =  "RM"+minSaving

            txtInvest.text =  "RM" + (minSaving * 0.30)
        }
    }

    private fun getSaving(age: Int): Double {
        return when (age) {
            in 16..20 -> 5000.00
            in 21..25 -> 14000.00
            in 26..30 -> 29000.00
            in 31..35 -> 50000.00
            in 36..40 -> 78000.00
            in 41..45 -> 116000.00
            in 46..50 -> 165000.00
            in 51..55 -> 228000.00
            else -> 0.00
        }
    }






}
