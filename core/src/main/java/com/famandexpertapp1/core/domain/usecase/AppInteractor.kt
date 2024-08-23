package com.famandexpertapp1.core.domain.usecase

import com.famandexpertapp1.core.data.Resource
import com.famandexpertapp1.core.domain.model.Franchise
import com.famandexpertapp1.core.domain.model.Games
import com.famandexpertapp1.core.domain.model.Screenshot
import com.famandexpertapp1.core.domain.repository.IAppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppInteractor @Inject constructor(private val appRepository: IAppRepository) : AppUseCase {
    override fun getAllFranchise(
        clientID: String,
        token: String,
    ) = appRepository.getAllFranchise(
        clientID = clientID,
        token = token,
    )

    override fun getFavoriteFranchise() = appRepository.getFavoriteFranchise()

    override fun setFavoriteFranchise(franchise: Franchise, state: Boolean) =
        appRepository.setFavoriteFranchise(franchise, state)

    override fun getDetailGames(
        clientID: String,
        token: String,
        gamesID: String?,
    ): Flow<Resource<List<Games>>> = appRepository.getDetailGames(
        clientID = clientID,
        token = token,
        gamesID = gamesID ?: null,
    )

    override fun getToken(): Flow<String> {
        return appRepository.getToken()
    }

    override fun setToken(value: String) {
        appRepository.setToken(value)
    }

    override fun getScreenshot(
        clientID: String,
        token: String,
        gamesID: String,
    ): Flow<Resource<List<Screenshot>>> {
        return appRepository.getScreenshot(
            clientID = clientID,
            token = token,
            gamesID = gamesID,
        )
    }
}