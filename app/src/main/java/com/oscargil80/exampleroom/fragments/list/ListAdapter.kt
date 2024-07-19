package com.oscargil80.exampleroom.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.exampleroom.R
import com.oscargil80.exampleroom.data.User
import com.oscargil80.exampleroom.databinding.CustomRowBinding

class ListAdapter(
    ):RecyclerView.Adapter<ListViewHolder>() {

    private var userList = emptyList<User>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return ListViewHolder(layoutInflater.inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.render(currentItem)
    }
    override fun getItemCount(): Int  = userList.size


    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}


/*
  class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
      var id: TextView

      init {
      id = itemView.findViewById(R.id.id_txt)
      }

    }
 */