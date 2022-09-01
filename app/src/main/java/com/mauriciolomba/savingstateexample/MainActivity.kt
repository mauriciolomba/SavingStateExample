package com.mauriciolomba.savingstateexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView : TextView
    private lateinit var botaoIncrementa : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoIncrementa = findViewById(R.id.botaoIncrementa)
        textView = findViewById(R.id.textView)

        val text = savedInstanceState?.getString("KEY_TEST") ?: "0"
        textView.text = text

        botaoIncrementa.setOnClickListener{
            var valorAtual = textView.text.toString().toInt()
            valorAtual++
            textView.text = valorAtual.toString()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val valor = textView.text.toString()
        outState.putString("KEY_TEST", valor)
    }


}