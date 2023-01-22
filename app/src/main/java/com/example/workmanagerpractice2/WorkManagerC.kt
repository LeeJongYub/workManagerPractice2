package com.example.workmanagerpractice2

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkManagerC(context: Context, workerParameters : WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result {

        for (i in 1..10) {
            Log.d("workManagerC", "$i")
            Thread.sleep(1000)
        }

        return Result.success()
    }

}