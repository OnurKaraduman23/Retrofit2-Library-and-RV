package com.example.retrofit_deneme

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RVAdapter(private val context:Context, private val apiList:List<MyDataItem>):RecyclerView.Adapter<RVAdapter.CardObjectHolder>() {
    inner class CardObjectHolder(view:View):RecyclerView.ViewHolder(view){
        var cardView:CardView
        var imageView:ImageView
        var textViewUserId:TextView
        var textViewTitle:TextView

        init {
            cardView = view.findViewById(R.id.cardView)
            imageView = view.findViewById(R.id.imageView)
            textViewUserId = view.findViewById(R.id.textViewUserId)
            textViewTitle = view.findViewById(R.id.textViewTitle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardObjectHolder {
        val tasarim = LayoutInflater.from(context).inflate(R.layout.card_user_id,parent,false)
        return CardObjectHolder(tasarim)
    }

    override fun getItemCount(): Int {
        return apiList.size
    }

    override fun onBindViewHolder(holder: CardObjectHolder, position: Int) {
        val userData = apiList[position]

        holder.textViewUserId.text = userData.id.toString()
        holder.textViewTitle.text = userData.title
//        holder.imageView.setImageResource(R.drawable.ic_android_white_24dp)
        val url ="https://images.unsplash.com/photo-1575936123452-b67c3203c357?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"
        Picasso.get()
            .load(url)
            .resize(300,300)
            .into(holder.imageView)


        holder.cardView.setOnClickListener {
            Toast.makeText(context,"${userData.id}. User Clicked",Toast.LENGTH_SHORT).show()
        }
    }


}