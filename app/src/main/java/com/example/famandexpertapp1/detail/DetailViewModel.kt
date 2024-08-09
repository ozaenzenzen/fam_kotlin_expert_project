package com.example.famandexpertapp1.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.famandexpertapp1.core.domain.usecase.AppUseCase

class DetailViewModel(useCase: AppUseCase) : ViewModel() {
    val data = useCase.getDetailGames().asLiveData()
}