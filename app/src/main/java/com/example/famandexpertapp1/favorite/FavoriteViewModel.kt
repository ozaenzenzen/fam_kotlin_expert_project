package com.example.famandexpertapp1.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.famandexpertapp1.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val useCase: AppUseCase) : ViewModel() {
    fun getListFavoriteFranchise() = useCase.getFavoriteFranchise()
}