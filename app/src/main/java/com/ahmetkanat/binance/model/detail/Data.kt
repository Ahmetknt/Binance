package com.ahmetkanat.binance.model.detail


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("ETH")
    val eTH: List<CoinDetail>?
)