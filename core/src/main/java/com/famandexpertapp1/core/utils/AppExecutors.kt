package com.famandexpertapp1.core.utils

import android.os.Handler
import android.os.Looper
import androidx.annotation.VisibleForTesting
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

@Suppress("unused")
class AppExecutors @VisibleForTesting constructor(
    private val diskIO: Executor,
    private val mainThread: Executor
) {

    companion object;

    @Inject
    constructor() : this(
        Executors.newSingleThreadExecutor(),
        MainThreadExecutor()
    )

    fun diskIO(): Executor = diskIO

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}
