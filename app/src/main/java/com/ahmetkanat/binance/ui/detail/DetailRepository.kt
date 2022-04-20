package com.ahmetkanat.binance.ui.detail

import com.ahmetkanat.binance.base.BaseRepository
import com.ahmetkanat.binance.network.ApiFactory
import javax.inject.Inject

class DetailRepository @Inject constructor(private val apiFactory: ApiFactory): BaseRepository(){

    suspend fun getDetail(
        apiKey : String,
        symbol : String
    ) = safeApiRequest {
        apiFactory.getDetail(apiKey,symbol)
    }
}