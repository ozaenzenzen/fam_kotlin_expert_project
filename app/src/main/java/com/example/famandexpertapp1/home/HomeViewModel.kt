package com.example.famandexpertapp1.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.famandexpertapp1.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: AppUseCase) : ViewModel() {
    fun dataDetail(clientID: String, token: String) = useCase.getDetailGames(
        clientID = clientID,
        token = token,
    ).asLiveData()

    fun dataList(clientID: String, token: String) = useCase.getAllFranchise(
        clientID, token,
    ).asLiveData()

    fun getScreenshot(clientID: String, token: String, gamesID: String) = useCase.getScreenshot(
        clientID, token, gamesID,
    ).asLiveData()

    fun removeToken() = useCase.setToken("")
    fun getToken() = useCase.getToken().asLiveData()
}