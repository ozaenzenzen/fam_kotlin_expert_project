package com.example.famandexpertapp1.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.famandexpertapp1.core.domain.usecase.AppUseCase

class HomeViewModel(private val useCase: AppUseCase) : ViewModel() {
    val dataDetail = useCase.getDetailGames().asLiveData()

    fun dataList(clientID: String, token: String) = useCase.getAllFranchise(
        clientID, token,
    ).asLiveData()
}