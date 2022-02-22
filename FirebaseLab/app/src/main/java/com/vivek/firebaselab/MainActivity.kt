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

    //I selected different region for Database so otherwise no need to write this code
    val regionReference = "https://fir-lab-9d8d4-default-rtdb.asia-southeast1.firebasedatabase.app/"
    val dbRef = FirebaseDatabase.getInstance(regionReference).reference
    fun saveBtn(view: View) {
        var name = binding.edtName.text.toString()
        if (name.isNotEmpty()) {

            //TODO 1. upload name to default root db
            //FirebaseDatabase.getInstance(regionReference).reference.setValue(name)

            //TODO 2. adding push will not overwrite the value
            //FirebaseDatabase.getInstance(regionReference).reference.push().setValue(name)

            //TODO 3. adding to particular nodes i.e. as child
            //dbRef.child("node").push().setValue(name)
            dbRef.child("todo").push().setValue(name)

        } else {
            binding.edtName.hint = "Please enter name"
        }
    }
}