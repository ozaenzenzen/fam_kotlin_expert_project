package com.example.famandexpertapp1.welcome

import androidx.lifecycle.ViewModel
import com.famandexpertapp1.core.domain.usecase.AppUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(private val useCase: AppUseCase) : ViewModel() {

}