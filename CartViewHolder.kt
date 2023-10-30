package com.example.cartapplication

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CartViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val ch: CheckBox =view.findViewById(R.id.ch)
    val delete: ImageView =view.findViewById(R.id.imageView)
}