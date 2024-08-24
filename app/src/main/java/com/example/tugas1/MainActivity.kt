package com.example.tugas1

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvRegister: TextView
    private lateinit var btnTogglePassword: ImageButton
    private var isPasswordVisible: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvRegister = findViewById(R.id.tvRegister)
        btnTogglePassword = findViewById(R.id.btnTogglePassword)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            } else {
                // Validasi kredensial yang benar
                val correctUsername = "user"
                val correctPassword = "pass123"

                if (username == correctUsername && password == correctPassword) {
                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                    // Lakukan tindakan setelah login berhasil di sini
                } else {
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnTogglePassword.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                // Tampilkan password
                etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                btnTogglePassword.setImageResource(R.drawable.ic_visibility)
            } else {
                // Sembunyikan password
                etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                btnTogglePassword.setImageResource(R.drawable.ic_visibility_off)
            }
            // Pindahkan kursor ke akhir input
            etPassword.setSelection(etPassword.text.length)
        }

        // Tangani klik teks register
        tvRegister.setOnClickListener {
            Toast.makeText(this, "Register clicked!", Toast.LENGTH_SHORT).show()
            // Intent ke halaman pendaftaran bisa dilakukan di sini
        }
    }
}
