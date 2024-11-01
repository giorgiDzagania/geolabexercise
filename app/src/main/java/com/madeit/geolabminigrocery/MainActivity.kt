package com.madeit.geolabminigrocery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.madeit.geolabminigrocery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val USER_NAME = "com.madeit.geolabminigrocery.userName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUp()
    }

    private fun setUp() {
        val name = binding.username.text
        val password = binding.password.text
        binding.btnCreateAccount.setOnClickListener {
            getUserInfo(userName = name.toString(), userPassword = password.toString())
        }
    }

    private fun getUserInfo(userName: String, userPassword: String) {
        if (userName.isEmpty() || userPassword.isEmpty()) {
            showToast(R.string.field_must_not_be_empty)
        } else if (userPassword.length < 8) {
            showToast(R.string.password_at_lease_8_char)
        } else {
            val intent = Intent(this@MainActivity, DetailsActivity::class.java)
            intent.putExtra(USER_NAME, userName)
            startActivity(intent)
        }
    }


    private fun showToast(message: Int) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }

}