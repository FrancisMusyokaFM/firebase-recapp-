package com.example.firebaserecapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firebaserecapp.databinding.ActivityMain2Binding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity2: AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.SignIn.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            if(checkAllField()) {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val kay = Intent(this, Welcome::class.java)
                        startActivity(kay)
                        finish()
                    }else{
                        Log.e("error", it.exception.toString())
                    }
                }
            }
        }

    }

    private fun checkAllField():Boolean {
        val email = binding.email.text.toString()
        if (binding.email.text.toString()== "") {
            binding.email.error = "Please input your email"
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.email.error = "Please input your email"
            return false
        }
        if (binding.password.text.toString() == "") {
            binding.password.error = "Please input your password"
            return false
        }
        return true
    }
}