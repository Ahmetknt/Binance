package com.ahmetkanat.binance.ui.home

import com.ahmetkanat.binance.model.home.Data

interface ItemClickListener {
    fun onItemClick(coin : Data)
}