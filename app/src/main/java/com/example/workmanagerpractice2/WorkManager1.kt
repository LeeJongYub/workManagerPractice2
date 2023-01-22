package com.example.workmanagerpractice2

import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

// 코루틴의 작동 방식

// 스레드 내에서 실행되지만, 스레드는 아니다.
// 스레드 안에 존재하는 고립된 환경에 존재하며, 스레드와 서로 영향을 받지 않는다

class WorkManager1(context: Context, workerParameters: WorkerParameters) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {

        work1()
        work2()

        return Result.success()
    }
}

suspend fun work1() {
    // 코루틴의 repeat()은 반복을 시행한다는 점에서 for()문과 같은 역할을 하는 것 같다.
    for (i in 1..10) {

        Log.d("work1", "$i")

        delay(1000)
        // sleep 으로 수행하면 스레드의 작업환경을 사용하는 코루틴도 같이 멈추게 된다.
        // 반면, delay 로 수행시 코루틴에만 영향을 준다.
    }

}

suspend fun work2() {

    for (i in 1..10) {

        Log.d("work2", "$i")

        delay(1000)
    }

}

