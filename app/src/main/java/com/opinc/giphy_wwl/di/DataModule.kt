package com.opinc.giphy_wwl.di

import android.content.Context
import com.opinc.giphy_wwl.R
import com.opinc.giphy_wwl.data.api.GiphyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().also {
            it.level = HttpLoggingInterceptor.Level.BODY
        })
        .addInterceptor {
            try {
                it.proceed(it.request())
            } catch (exception: Exception) {
                val jsonObject = JSONObject()
                jsonObject.put("status", "Error")
                jsonObject.put("message", "${exception.message}")
                jsonObject.put("errors", "${exception.stackTrace}")
                val body =
                    jsonObject.toString().toResponseBody("application/json".toMediaTypeOrNull())
                return@addInterceptor Response.Builder().body(body)
                    .code(500)
                    .message("${exception.message}")
                    .request(it.request())
                    .protocol(Protocol.HTTP_1_1)
                    .build()
            }
        }
        .connectTimeout(5, TimeUnit.SECONDS)
        .writeTimeout(5, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    @Named("GiphyApi")
    fun provideRetrofit(
        client: OkHttpClient,
        @ApplicationContext context: Context
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.BASE_URL))
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideGiphyApi(
        @Named("GiphyApi") retrofit: Retrofit,
    ): GiphyApi = retrofit.create(GiphyApi::class.java)

}