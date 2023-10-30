package com.example.cartapplication


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cartapplication.database.Cart
import com.example.cartapplication.database.CartRepository


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CartAdapter (items:List<Cart>, repository: CartRepository, viewModel: MainActivityData):RecyclerView.Adapter<CartViewHolder>(){
    var context: Context? =null
    val items =items
    val repository=repository
    val viewModel=viewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_cart,parent,false)
        context = parent.context
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cart = items[position]
        val cartInfo = "${cart.name},${cart.description}"
        holder.ch.text = cartInfo
        holder.delete.setOnClickListener{
            val isChecked=holder.ch.isChecked

            if(isChecked){
                CoroutineScope(Dispatchers.IO).launch {
                    repository.delete(items.get(position))
                    val data= repository.getAllCart()
                    withContext(Dispatchers.Main){
                        viewModel.setData((data))
                    }
                }
            }else {
                Toast.makeText(context, "select the Shopping Cart", Toast.LENGTH_LONG).show()
            }
        }
    }
}