package com.vivek.jetpacktest.ui

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyWorker(var con: Context,val param:WorkerParameters) :CoroutineWorker(con,param) {
    override suspend fun doWork(): Result {
        val res = withContext(Dispatchers.IO){
            //api call
        }
        return Result.success()
    }

}