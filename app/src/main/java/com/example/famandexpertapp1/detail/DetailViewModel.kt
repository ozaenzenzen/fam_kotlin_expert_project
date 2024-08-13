package com.example.famandexpertapp1.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.famandexpertapp1.core.domain.model.Franchise
import com.famandexpertapp1.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val useCase: AppUseCase) : ViewModel() {
    fun dataDetail(clientID: String, token: String, gamesID: String?) = useCase.getDetailGames(
        clientID = clientID,
        token = token,
        gamesID = gamesID ?: null,
    )

    fun getToken() = useCase.getToken()

    fun setFavoriteFranchise(franchise: Franchise, newStatus: Boolean) =
        useCase.setFavoriteFranchise(franchise, newStatus)
}