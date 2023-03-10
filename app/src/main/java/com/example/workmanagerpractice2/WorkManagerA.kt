package com.example.workmanagerpractice2

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class WorkManagerA(context: Context, workerParameters : WorkerParameters) : Worker(context, workerParameters) {

    override fun doWork(): Result {

        for(i in 1..10) {
            Log.d("workManagerA", "$i")
            sleep(1000)
        }

        return Result.success()
    }

}
