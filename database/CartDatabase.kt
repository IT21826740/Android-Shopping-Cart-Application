package com.example.cartapplication.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cart::class], version = 1)
abstract class CartDatabase:RoomDatabase() {
    abstract fun getCartDao():CartDao

    companion object{
        @Volatile
        private var INSTANCE:CartDatabase?=null

        fun getInstance(context: Context):CartDatabase{
            synchronized(this){
                return INSTANCE?: Room.databaseBuilder(
                    context,
                    CartDatabase::class.java,
                    "Cart_db"

                ).build().also {
                    INSTANCE=it
                }
            }
        }
    }
}