package com.famandexpertapp1.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.famandexpertapp1.core.domain.usecase.AppUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val useCase: AppUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(useCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: ${modelClass.name}")
        }
}