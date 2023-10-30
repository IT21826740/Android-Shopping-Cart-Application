package com.example.cartapplication.database

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Cart(

var name:String?,
var description:String?,
){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}
