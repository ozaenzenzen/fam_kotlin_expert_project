package com.example.famandexpertapp1.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.famandexpertapp1.core.BuildConfig.ACCESS_TOKEN
import com.famandexpertapp1.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: AppUseCase) : ViewModel() {
    fun setToken(value: String) = useCase.setToken(
        ACCESS_TOKEN,
    )

    fun getToken() = useCase.getToken().asLiveData()
}