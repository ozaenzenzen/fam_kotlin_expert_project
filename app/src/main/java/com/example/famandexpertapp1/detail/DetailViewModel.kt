package com.example.famandexpertapp1.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.famandexpertapp1.core.domain.usecase.AppUseCase

class DetailViewModel(private val useCase: AppUseCase) : ViewModel() {
    fun dataDetail(clientID: String, token: String) = useCase.getDetailGames(
        clientID = clientID,
        token = token,
    ).asLiveData()
}