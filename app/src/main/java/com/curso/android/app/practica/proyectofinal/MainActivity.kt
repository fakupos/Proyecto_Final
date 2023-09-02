package com.curso.android.app.practica.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val viewModel: ComparisonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val compareButton = findViewById<Button>(R.id.compareButton)
        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        compareButton.setOnClickListener {
            val text1 = editText1.text.toString()
            val text2 = editText2.text.toString()
            viewModel.compareStrings(text1, text2)
        }

        viewModel.comparisonResultLiveData.observe(this, Observer { result ->
            resultTextView.text =
                if (result.areEqual) "Las cadenas son iguales" else "Las cadenas son diferentes"
        })
    }
}
