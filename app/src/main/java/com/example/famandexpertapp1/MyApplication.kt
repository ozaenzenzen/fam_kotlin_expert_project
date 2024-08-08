package com.example.famandexpertapp1

import android.app.Application
import com.example.famandexpertapp1.di.AppComponent
import com.famandexpertapp1.core.di.CoreComponent

open class MyApplication : Application() {

//    private val coreComponent: CoreComponent by lazy {
//        DaggerCoreComponent.factory().create(applicationContext)
//    }
//
//    val appComponent: AppComponent by lazy {
//        DaggerAppComponent.factory().create(coreComponent)
//    }
}