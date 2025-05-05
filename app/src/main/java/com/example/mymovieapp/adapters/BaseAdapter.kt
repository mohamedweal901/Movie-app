package com.example.mymovieapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovieapp.databinding.MovieItemBinding
import com.example.mymovieapp.model.data.Movie


interface BaseInteractionListener

abstract class BaseAdapter<T>(private var items:List<T>, val listener:BaseInteractionListener): RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {
    abstract class BaseViewHolder(val itemView: ViewDataBinding): RecyclerView.ViewHolder(itemView.root)

    fun setItems(newItems:List<T>){
        items=newItems
    }

    fun getItems():List<T>{
        return items
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemViewHolder(val binding: MovieItemBinding):BaseViewHolder(binding)

    abstract val layoutId:Int
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),layoutId,parent,false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem=items[position]
        when(holder){
            is ItemViewHolder->{
                holder.binding.setVariable(BR.listener,listener)
                holder.binding.setVariable(BR.item,currentItem)
            }
        }
    }

}