package com.vivek.firebaselab

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.*
import com.vivek.firebaselab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var notes = arrayListOf<String>()
    val regionReference = "https://fir-lab-9d8d4-default-rtdb.asia-southeast1.firebasedatabase.app/"
    var dbRef: DatabaseReference? = null
    lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dbRef = FirebaseDatabase.getInstance(regionReference).reference
        adapter = ArrayAdapter<String>(this, R.layout.item_row, R.id.tv_note_name, notes)
        binding.listview.adapter = adapter

        dbRef?.child("todo")?.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val myD = snapshot.value.toString()
                notes.add(myD)
                adapter.notifyDataSetChanged()
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        )
    }

    //I selected different region for Database so otherwise no need to write this code
    fun saveBtn(view: View) {
        var name = binding.edtName.text.toString()
        if (name.isNotEmpty()) {

            //TODO 1. upload name to default root db
            //FirebaseDatabase.getInstance(regionReference).reference.setValue(name)

            //TODO 2. adding push will not overwrite the value
            //FirebaseDatabase.getInstance(regionReference).reference.push().setValue(name)

            //TODO 3. adding to particular nodes i.e. as child
            //dbRef.child("node").push().setValue(name)
            //TODO 4. can save data as object
            //POJO pojo = new POJO("name","lastname");
            //FirebaseDatabase.getInstance(regionReference).reference.push().setValue(pojo)
            dbRef?.child("todo")?.push()?.setValue(name)
        } else {
            binding.edtName.hint = "Please enter name"
        }
    }

}