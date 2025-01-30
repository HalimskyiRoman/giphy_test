package com.opinc.giphy_wwl.data.api

import com.opinc.giphy_wwl.data.model.response.GiphyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApi {
    @GET("gifs/trending")
    suspend fun getData(
        @Query("api_key") apiKey: String,
        @Query("limit") limit: Int = 100
    ): Response<GiphyResponse>
}