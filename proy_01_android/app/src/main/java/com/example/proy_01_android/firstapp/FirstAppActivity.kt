package com.example.proy_01_android.firstapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proy_01_android.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_app)

        val btnStart =findViewById<AppCompatButton>(R.id.btnStart)
        val etName =findViewById<AppCompatEditText>(R.id.etName)


        btnStart.setOnClickListener{
            //Toast.makeText(this, "¡Botón presionado!", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "¡Botón presionado! ${etName.text.toString()}", Toast.LENGTH_SHORT).show()

            Log.i("aristiDev","Boton pulsado con ${etName.text.toString()}")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}