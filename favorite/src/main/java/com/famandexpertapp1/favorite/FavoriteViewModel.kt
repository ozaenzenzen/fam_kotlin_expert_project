package com.famandexpertapp1.favorite

import androidx.lifecycle.ViewModel
import com.famandexpertapp1.core.domain.usecase.AppUseCase

class FavoriteViewModel(private val useCase: AppUseCase) : ViewModel() {
    fun getListFavoriteFranchise() = useCase.getFavoriteFranchise()
}