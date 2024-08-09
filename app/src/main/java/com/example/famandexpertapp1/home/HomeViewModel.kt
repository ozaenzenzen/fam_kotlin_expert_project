package com.example.famandexpertapp1.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.famandexpertapp1.core.domain.usecase.AppUseCase

class HomeViewModel(useCase: AppUseCase) : ViewModel() {
    val data = useCase.getDetailGames().asLiveData()
    val dataList = useCase.getAllFranchise().asLiveData()
}