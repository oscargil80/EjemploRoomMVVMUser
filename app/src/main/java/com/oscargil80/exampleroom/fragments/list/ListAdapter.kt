package com.oscargil80.exampleroom.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.exampleroom.R
import com.oscargil80.exampleroom.model.User

class ListAdapter(
    private val onClick: (User) ->Unit
):RecyclerView.Adapter<ListViewHolder>() {

    private var userList = emptyList<User>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return ListViewHolder(layoutInflater.inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.render(currentItem, onClick)


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