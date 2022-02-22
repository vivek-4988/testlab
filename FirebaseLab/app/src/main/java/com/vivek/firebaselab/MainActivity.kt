package com.vivek.firebaselab

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.FirebaseDatabase
import com.vivek.firebaselab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    fun saveBtn(view: View) {
        var name = binding.edtName.text.toString()
        if (name.isNotEmpty()) {
            //I selected different region for Database so otherwise no need to write this code
            val regionReference = "https://fir-lab-9d8d4-default-rtdb.asia-southeast1.firebasedatabase.app/"
            //upload name
            FirebaseDatabase.getInstance(regionReference).reference.setValue(name)
            //var dbReference =

        } else {
            binding.edtName.hint = "Please enter name"
        }
    }
}