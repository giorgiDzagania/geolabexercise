package com.madeit.geolabminigrocery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.madeit.geolabminigrocery.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var getUserName: String
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.itemCount.text = count.toString()

        getUserInfo()
        backBtn()
        btnMinusClick()
        btnAddClick()
        purchaseItem()
    }

    private fun getUserInfo() {
        val intent = intent
        getUserName = intent.getStringExtra(MainActivity.USER_NAME) ?: ""
        binding.tvUsername.text = getUserName
    }

    private fun backBtn() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun btnMinusClick() {
        binding.btnMinus.setOnClickListener {
            if (count > 0) {
                count--
                binding.itemCount.text = count.toString()
            } else {
                showToast(R.string.count_cant_be_negative_number)
            }
        }
    }

    private fun btnAddClick() {
        binding.btnAdd.setOnClickListener {
            count++
            binding.itemCount.text = count.toString()
        }
    }

    private fun purchaseItem() {
        val nameOfItem = binding.itemName.text.toString()
        binding.btnOrder.setOnClickListener {
            if (count > 0){
                Toast.makeText(this@DetailsActivity,
                    "$getUserName bought $count $nameOfItem", Toast.LENGTH_SHORT).show()
            }else
                return@setOnClickListener
        }
    }

    private fun showToast(message: Int) {
        Toast.makeText(this@DetailsActivity, message, Toast.LENGTH_SHORT).show()
    }
}