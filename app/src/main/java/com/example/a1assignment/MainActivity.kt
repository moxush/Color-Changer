package com.example.a1assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerColor: Spinner
    private lateinit var buttonApply: Button
    private lateinit var textviewColor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerColor = findViewById<Spinner>(R.id.spinner_color)
        buttonApply = findViewById<Button>(R.id.button_apply)
        textviewColor = findViewById<TextView>(R.id.textview_color)

        val colorOptions = arrayOf("Red", "Green", "Blue", "Yellow", "Purple")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colorOptions)
        spinnerColor.adapter = adapter

        spinnerColor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedColor = colorOptions[position]
                textviewColor.text = "You selected: $selectedColor"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        buttonApply.setOnClickListener {
            val selectedColor = spinnerColor.selectedItem as String
            when (selectedColor) {
                "Red" -> textviewColor.setBackgroundColor(resources.getColor(R.color.red))
                "Green" -> textviewColor.setBackgroundColor(resources.getColor(R.color.green))
                "Blue" -> textviewColor.setBackgroundColor(resources.getColor(R.color.blue))
                "Yellow" -> textviewColor.setBackgroundColor(resources.getColor(R.color.yellow))
                "Purple" -> textviewColor.setBackgroundColor(resources.getColor(R.color.purple))
            }
        }
    }
}