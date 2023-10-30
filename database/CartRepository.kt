package com.example.cartapplication.database

class CartRepository (private val db:CartDatabase){
    suspend fun insert(cart: Cart) =db.getCartDao().insert(cart)
    suspend fun delete(cart: Cart)=db.getCartDao().delete(cart)

    fun getAllCart():List<Cart> = db.getCartDao().getAllCart()
}