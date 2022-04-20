package com.ahmetkanat.binance.ui.home

import com.ahmetkanat.binance.base.BaseRepository
import com.ahmetkanat.binance.network.ApiFactory
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiFactory: ApiFactory): BaseRepository() {

    suspend fun getData(
        apiKey : String,
        limit : String
    ) = safeApiRequest {
        apiFactory.getData(apiKey,limit)
    }
}