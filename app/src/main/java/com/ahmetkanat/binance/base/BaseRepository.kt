package com.ahmetkanat.binance.base

import com.ahmetkanat.binance.model.errorResponse.ErrorResponse
import com.ahmetkanat.binance.utils.NetworkResult
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.CacheRequest

abstract class BaseRepository {

    suspend fun <T> safeApiRequest(
        apiRequest: suspend () -> T): NetworkResult<T>{
        return withContext(Dispatchers.IO){
            try {
                NetworkResult.Success(apiRequest.invoke())
            }catch (throwable: Throwable){
                when(throwable){
                    is HttpException -> {
                        NetworkResult.Error(false, errorBodyParser(throwable.response()?.errorBody()?.string()))
                    }
                    else ->  NetworkResult.Error(true,throwable.localizedMessage)
                }
            }
        }
    }
}

private fun errorBodyParser(error: String?): String{
    error?.let {
        return try {
            val errorResponse = Gson().fromJson(error, ErrorResponse::class.java)
            val errorMessage = errorResponse.status?.errorMessage
            errorMessage ?: "Bilinmeyen bir hata oluştu"
        }catch (e: Exception){
            "Bilinmeyen bir hata oluştu"
        }
    }
    return "Bilinmeyen bir hata oluştu"
}