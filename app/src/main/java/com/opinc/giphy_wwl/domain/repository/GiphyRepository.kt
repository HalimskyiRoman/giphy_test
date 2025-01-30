package com.opinc.giphy_wwl.domain.repository

import com.opinc.giphy_wwl.data.model.response.GiphyResponse
import com.opinc.giphy_wwl.domain.data.GiphyModel
import com.opinc.giphy_wwl.domain.utils.BaseResult
import kotlinx.coroutines.flow.Flow

interface GiphyRepository {

    suspend fun getData(): Flow<BaseResult<GiphyModel>>

}