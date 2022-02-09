package com.example.recyclerviewwithfirebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var userList:ArrayList<User>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_user, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val curr = userList[position]
        holder.firstName.text = curr.firstName
        holder.lastName.text = curr.lastName
        holder.age.text = curr.age.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val firstName = itemView.findViewById<TextView>(R.id.firstName)
        val lastName = itemView.findViewById<TextView>(R.id.lastName)
        val age = itemView.findViewById<TextView>(R.id.age)
    }

}