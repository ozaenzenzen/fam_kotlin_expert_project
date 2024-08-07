package com.example.famandexpertapp1.di

import com.example.famandexpertapp1.detail.DetailActivity
import com.example.famandexpertapp1.favorite.FavoriteActivity
import com.example.famandexpertapp1.home.HomeActivity
import com.example.famandexpertapp1.welcome.MainActivity
import com.famandexpertapp1.core.di.CoreComponent
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class],
)

interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: HomeActivity)
    fun inject(activity: DetailActivity)
    fun inject(activity: FavoriteActivity)
}