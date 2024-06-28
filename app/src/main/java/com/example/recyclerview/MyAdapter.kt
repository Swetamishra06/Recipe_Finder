package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import layout.News

class MyAdapter(
    private val arrayList: ArrayList<News>,
    private val context: Activity
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var listener: myOnclicklistener
    interface myOnclicklistener{
        fun onItemClick(position :Int)

    }
    fun setitemclicklistener(mylistener :myOnclicklistener){
     listener = mylistener
    }

    class MyViewHolder(itemView: View,listener : myOnclicklistener) : RecyclerView.ViewHolder(itemView) {
        val heading: TextView = itemView.findViewById(R.id.text)
        val fimage: ShapeableImageView = itemView.findViewById(R.id.image)
        //the code inside the init block is the first to be executed when the class is instantiated
        init{
itemView.setOnClickListener {
    //tell you adapter's current position
    listener.onItemClick(adapterPosition)
}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachitem, parent, false)
        return MyViewHolder(itemView,listener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = arrayList[position]
        holder.heading.text = currentItem.foodname
        holder.fimage.setImageResource(currentItem.foodimage)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}

