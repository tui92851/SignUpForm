package edu.temple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import android.widget.Toast
import android.widget.EditText
import android.widget.Button

class FormActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val address = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val confirmPass = findViewById<EditText>(R.id.editTextTextPassword2)
        val user = findViewById<EditText>(R.id.editTextTextPersonName)
        val firstPass = findViewById<EditText>(R.id.editTextTextPassword)

        val btn = findViewById<Button>(R.id.button)

        val ocl = View.OnClickListener {
            val saveEmail = address.text.toString()
            val emailEmpty = saveEmail.isEmpty()

            val savePW = firstPass.text.toString()
            val passEmpty = savePW.isEmpty()

            val confirmPW = confirmPass.text.toString()
            val confirmEmpty = confirmPW.isEmpty()

            val username = user.text.toString()
            val userEmpty = username.isEmpty()

            val samePass = (savePW == confirmPW)

            if (userEmpty) {
                user.error = "Please provide a username!"
            }

            if (emailEmpty) {
                address.error = "Please provide an email address!"
            }

            if (passEmpty) {
                firstPass.error = "Please provide a password!"
            }

            if (confirmEmpty) {
                confirmPass.error = "Please confirm password!"
            }

            if (!samePass) {
                if (!passEmpty) {
                    firstPass.error = "Passwords don't match!"
                }

                if (!confirmEmpty) {
                    confirmPass.error = "Passwords don't match!"
                }

            }

            if (!userEmpty && !emailEmpty && !passEmpty && !confirmEmpty && samePass) {
                val welcome = "Thanks for registering friend!"
                Toast.makeText(this@FormActivity, welcome, Toast.LENGTH_LONG).show()
                Log.d("Message", "All good")
            }
        }

        btn.setOnClickListener(ocl) // assign OCL
    }
}