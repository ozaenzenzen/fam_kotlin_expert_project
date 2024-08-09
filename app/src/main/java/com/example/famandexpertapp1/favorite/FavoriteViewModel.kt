package com.example.famandexpertapp1.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.famandexpertapp1.core.domain.usecase.AppUseCase

class FavoriteViewModel(useCase: AppUseCase) : ViewModel() {
    val data = useCase.getFavoriteFranchise().asLiveData()
}