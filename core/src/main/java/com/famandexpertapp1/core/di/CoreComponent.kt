package com.famandexpertapp1.core.di

import android.content.Context
import com.famandexpertapp1.core.domain.repository.IAppRepository
import dagger.BindsInstance
import dagger.Component

interface CoreComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideRepository(): IAppRepository
}