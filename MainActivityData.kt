package com.example.cartapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cartapplication.database.Cart


class MainActivityData : ViewModel(){
    private val _data= MutableLiveData<List<Cart>>()


    val data: LiveData<List<Cart>> =_data


    fun setData(data:List<Cart>){
        _data.value=data
    }

}