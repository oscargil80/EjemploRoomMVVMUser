package com.oscargil80.exampleroom.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.exampleroom.R
import com.oscargil80.exampleroom.data.User
import com.oscargil80.exampleroom.databinding.CustomRowBinding

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    private var userList = emptyList<User>()

    inner class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
      var id: TextView

      init {
      id = itemView.findViewById(R.id.id_txt)
      }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]




      /*  var firsName : TextView = holder.itemView.findViewById<TextView>(R.id.firstName_txt)
        firsName.setText(currentItem.firstName)

        var lastName : TextView = holder.itemView.findViewById<TextView>(R.id.lastName_txt)
        lastName.setText(currentItem.lastName)

        var age : TextView = holder.itemView.findViewById<TextView>(R.id.age_txt)
        age.setText(currentItem.age)*/

    }

    override fun getItemCount(): Int  = userList.size

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }

}