package com.example.mymovieapp.model

sealed class State<out T>{
    data class Success<T>(val data:T?=null):State<T>()
    data class Error(val message:String):State<Nothing>()
    object Loading:State<Nothing>()
    fun toData():T?{
        if(this is Success){
            return data
        }else{
            return null
        }
    }
}
