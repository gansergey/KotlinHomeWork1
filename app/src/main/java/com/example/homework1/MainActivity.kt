package com.example.homework1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var testList: List<String>

    private lateinit var textView: TextView

    @SuppressLint("SetTextI18n")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testButton = findViewById<Button>(R.id.test_button)
        val personButton = findViewById<Button>(R.id.person_button)
        val placeWorkButton = findViewById<Button>(R.id.place_work_button)

        textView = findViewById(R.id.text_view)

        testList = listOf("Запись1", "Запись2", "Запись3")

        testButton.setOnClickListener {
            textView.text = getString(R.string.text_on_button)
        }

        personButton.setOnClickListener {
            val person = Person()
            textView.text = "${person.firstName} ${person.lastName}"
        }

        placeWorkButton.setOnClickListener {
            val placeWork = PlaceWork()
            val placeWorkCopy = placeWork.copy(city = "Москва")
            textView.text = "${placeWorkCopy.county} ${placeWorkCopy.city}"
        }

        showList()
        println(sumNumbers(4, 5, 10))

    }

    @SuppressLint("SetTextI18n")
    fun showList() {
        for (i in testList) {
            textView.text = "${textView.text} $i"
        }
    }

    private fun sumNumbers(a: Int, b: Int, c: Int): Int {
        return if (a == 10 || b == 10 || c == 10) a + b + c else 0
    }

}

