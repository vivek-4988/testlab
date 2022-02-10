package com.vivek.retrofitcoroutine

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vivek.retrofitcoroutine.databinding.ActivityMainBinding
import com.vivek.retrofitcoroutine.model.QuoteListDo
import com.vivek.retrofitcoroutine.network.RequestAPI
import com.vivek.retrofitcoroutine.network.RetroHelper
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val quotesApi = RetroHelper.getInstance().create(RequestAPI::class.java)

        //second way
        GlobalScope.launch(IO) {
            val result = quotesApi.getQuotes()

            withContext(Main) {
                showResponse(result.body())
            }
        }

        /* first way */
        // launching a new coroutine
        /*
        runBlocking {
            launch {
                val result = quotesApi.getQuotes()
                Log.d("quotes: ", result.body().toString())
                showResponse(result.body())
            }
        }
        */
    }

    private fun showResponse(body: QuoteListDo?) {
        val list = body?.results
        var myQuotes: ArrayList<String> = ArrayList()
        for (items in list!!) {
            myQuotes.add(items.content)
        }
        var arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, myQuotes
        )
        binding.recycle.apply {
            adapter = arrayAdapter
        }
    }
}