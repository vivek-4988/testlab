package com.vivek.mvvmsample

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.vivek.mvvmsample.data.models.UsersItem
import com.vivek.mvvmsample.databinding.ActivityMainBinding
import com.vivek.mvvmsample.ui.adapter.UserAdapter
import com.vivek.mvvmsample.ui.viewmodel.GithubViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val vm by lazy {
        ViewModelProvider(this).get(GithubViewModel::class.java)
    }

    val list = arrayListOf<UsersItem>()
    val userAdapter = UserAdapter(this, list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                findUsers(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })


        /*
        * TODO getting users
        * */
        binding.recycle.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = userAdapter
        }
        vm.fetchUser()
        vm.users.observe(this, Observer {
            if (it.isNotEmpty()) {
                list.addAll(it)
                userAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun findUsers(query: String) {
        vm.searchUsers(query).observe(this, Observer {
            if (!it.isNullOrEmpty()) {
                list.clear()
                val checkItem : List<UsersItem> = it as List<UsersItem>
                list.addAll(checkItem)
                userAdapter.notifyDataSetChanged()
            }
        })
    }
}

