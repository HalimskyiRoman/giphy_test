package com.opinc.giphy_wwl.data.repository

import com.opinc.giphy_wwl.data.api.GiphyApi
import com.opinc.giphy_wwl.data.model.response.mapToGiphyModel
import com.opinc.giphy_wwl.domain.data.GiphyModel
import com.opinc.giphy_wwl.domain.repository.GiphyRepository
import com.opinc.giphy_wwl.domain.utils.BaseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GiphyRepositoryImpl @Inject constructor(
    private val giphyApi: GiphyApi,
) : GiphyRepository {
    override suspend fun getData(): Flow<BaseResult<GiphyModel>> = flow {
        try {
            val response = giphyApi.getData("_", )
            if (response.isSuccessful) {
                response.body()?.let { responseBody ->
                    emit(BaseResult.Success(responseBody.mapToGiphyModel()))
                } ?: emit(BaseResult.Error)
            } else {
                emit(BaseResult.Error)
            }
        } catch (e: IOException) {
            emit(BaseResult.Error)
            e.printStackTrace()
        }
    }
}
