package com.talos.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LogedActivity : AppCompatActivity() {
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loged)


        var btExit = findViewById<Button>(R.id.btExit)
        var exitMessage : String = getString(R.string.logout_message)

        btExit.setOnClickListener {


            val intent = Intent(this, MainActivity::class.java)

            Toast.makeText(this, "$exitMessage" , Toast.LENGTH_SHORT).show()

            register.launch(intent)
        }
    }

}