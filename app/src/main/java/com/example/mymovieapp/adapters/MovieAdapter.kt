package com.example.mymovieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovieapp.R
import com.example.mymovieapp.model.data.Movie

class MovieAdapter(items:List<Movie>,listener: MovieInteractionListener): BaseAdapter<Movie>(items,listener){
    override val layoutId: Int
        get() = R.layout.movie_item
}
interface MovieInteractionListener:BaseInteractionListener{
    fun onClickMovie(movie: Movie)
}
