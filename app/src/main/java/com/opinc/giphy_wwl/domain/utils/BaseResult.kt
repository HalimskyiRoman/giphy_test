package com.opinc.giphy_wwl.domain.utils

import retrofit2.Response

sealed interface BaseResult<out T> {
    data class Success<out T : Any>(val data: T) : BaseResult<T>
    object Error : BaseResult<Nothing>
}

