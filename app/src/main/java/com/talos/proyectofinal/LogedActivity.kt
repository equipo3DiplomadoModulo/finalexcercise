package com.talos.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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

        val tvUser = findViewById<TextView>(R.id.tvUser)
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvSex = findViewById<TextView>(R.id.tvSex)


        // Dato user que proviene de fragment_send_params
        intent.extras?.let {
            if (it.containsKey("EXTRA_USER")) { // no se debe repetir EXTRA_USER en fragment_receive_params
                val user = it.getString("EXTRA_USER").toString()
                tvUser.text = user
                tvName.text = "Juan Pérez Pérez" // por poner un nombre
                var mail = user.lowercase()
                tvEmail.text= user + "@gmail.com" // por poner un correo
                tvSex.text= "Hombre"

               // Toast.makeText(this, "$user" , Toast.LENGTH_SHORT).show()
            }
            if (it.containsKey("EXTRA_NAME")) {
                val name = it.getString("EXTRA_NAME").toString()
                val secondname = it.getString("EXTRA_SECOND_NAME").toString()
                val user = it.getString("EXTRA_USERNAME").toString()
                val email = it.getString("EXTRA_EMAIL").toString()
                val gender = it.getString("EXTRA_GENDER").toString()

                tvName.text = name + " " + secondname
                tvUser.text = user
                tvEmail.text= email
                tvSex.text= gender

                 //Toast.makeText(this, "Paso un dato porque hay name" , Toast.LENGTH_SHORT).show()
            }
        }

        var btExit = findViewById<Button>(R.id.btExit)
        var exitMessage : String = getString(R.string.logout_message)

        btExit.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)

            Toast.makeText(this, "$exitMessage" , Toast.LENGTH_SHORT).show()

            register.launch(intent)
        }





    }

}