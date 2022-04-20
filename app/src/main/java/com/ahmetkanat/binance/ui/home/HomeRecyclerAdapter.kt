package com.ahmetkanat.binance.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmetkanat.binance.databinding.RecyclerRowBinding
import com.ahmetkanat.binance.model.home.Data

class HomeRecyclerAdapter(private val listener: ItemClickListener) : RecyclerView.Adapter<HomeRecyclerAdapter.CoinHolder>() {

    private var coin = emptyList<Data>()

    class CoinHolder(private val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(listener: ItemClickListener,coin : Data){
            binding.onItemClickListener = listener
            binding.coin = coin
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup) : CoinHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecyclerRowBinding.inflate(layoutInflater,parent,false)
                return CoinHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CoinHolder.from(parent)

    override fun onBindViewHolder(holder: CoinHolder, position: Int) = holder.bind(listener,coin[position])

    override fun getItemCount() = coin.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList : List<Data>){
        coin = newList
        notifyDataSetChanged()
    }
}