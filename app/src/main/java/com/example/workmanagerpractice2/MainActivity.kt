package com.example.workmanagerpractice2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. WorkManager Chaining 실습
        // 여러 종속 작업을 지정하고, 체이닝(실행 순서를 정의)하여 구현하는 방법

        val workManagerA = OneTimeWorkRequestBuilder<WorkManagerA>().build()
        val workManagerB = OneTimeWorkRequestBuilder<WorkManagerB>().build()
        val workManagerC = OneTimeWorkRequestBuilder<WorkManagerC>().build()

        WorkManager.getInstance(this)
            .beginWith(listOf(workManagerA, workManagerB))
            // beginWith(listOf())로 먼저 실행할 workManager 를 지정
            .then(workManagerC)
            // then() 으로 다음 실행을 지정
            .enqueue()
            //.enqueue 로 실행한다.


        // 2. WorkManager + Coroutine 실습
        // 코루틴을 통한 체이닝 작업을 구현하는 방법

        val workManager1 = OneTimeWorkRequestBuilder<WorkManager1>().build()
        WorkManager.getInstance(this).enqueue(workManager1)
    }
}




