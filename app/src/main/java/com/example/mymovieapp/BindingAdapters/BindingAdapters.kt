package com.example.mymovieapp.BindingAdapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovieapp.adapters.BaseAdapter
import com.example.mymovieapp.adapters.MovieAdapter
import com.example.mymovieapp.model.data.Movie
import com.example.mymovieapp.model.State

@BindingAdapter(value = ["app:showWhenSuccess"])
fun<T>showWhenSuccess(view: View,state: State<T>?){
    if(state is State.Success){
        view.visibility=View.VISIBLE
    }else{
        view.visibility=View.GONE
    }
}

@BindingAdapter(value = ["app:showWhenLoading"])
fun<T>showWhenLoading(view: View,state: State<T>?){
    if(state is State.Loading){
        view.visibility=View.VISIBLE
    }else{
        view.visibility=View.GONE
    }
}

@BindingAdapter(value = ["app:showWhenError"])
fun<T>showWhenError(view: View,state: State<T>?){
    if(state is State.Error){
        view.visibility=View.VISIBLE
    }else{
        view.visibility=View.GONE
    }
}

@BindingAdapter(value = ["app:imageUrl"])
fun setImageFromUrl(imageView: ImageView,url:String?){
    Glide.with(imageView).load(url).centerCrop().into(imageView)
}

@BindingAdapter(value = ["app:items"])
fun<T>setRecyclerViewItems(view: RecyclerView, items:List<T>?){
    if(items!=null) {
        val adapter = view.adapter as BaseAdapter<T>
        adapter.setItems(items)
    }else{
        val adapter=view.adapter as BaseAdapter<T>
        adapter.setItems(emptyList())
    }
}
