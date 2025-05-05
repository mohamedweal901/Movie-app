package com.example.mymovieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView


interface BaseInteractionListener
abstract class BaseAdapter<T>(private var items:List<T>, val listener: BaseInteractionListener): RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {
    abstract class BaseViewHolder(binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root)

    class ItemViewHolder(val binding: ViewDataBinding):BaseViewHolder(binding)

    override fun getItemCount()= items.size

    abstract val layoutId:Int
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        return ItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),layoutId,parent,false))
    }

    fun setItems(newItems:List<T>){
        items=newItems
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem=items[position]
        when(holder){
            is ItemViewHolder ->{
                holder.binding.setVariable(BR.listener,listener)
                holder.binding.setVariable(BR.item,currentItem)
            }
        }
    }
    fun getItems()=items
}