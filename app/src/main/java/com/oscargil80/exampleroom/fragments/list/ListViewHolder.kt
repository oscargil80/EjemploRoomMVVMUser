package com.oscargil80.exampleroom.fragments.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.oscargil80.exampleroom.data.User
import com.oscargil80.exampleroom.databinding.CustomRowBinding

class ListViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private  var binding = CustomRowBinding.bind(view)

    fun render (user:User){
        binding.idtx.text = user.id.toString()
       binding.firstNametxt.text = user.firstName.toString()
        binding.lastNametxt.text = user.lastName.toString()
        binding.agetxt.text = user.age.toString()
    }
}

/*/*  var firsName : TextView = holder.itemView.findViewById<TextView>(R.id.firstName_txt)
        firsName.setText(currentItem.firstName)

        var lastName : TextView = holder.itemView.findViewById<TextView>(R.id.lastName_txt)
        lastName.setText(currentItem.lastName)

        var age : TextView = holder.itemView.findViewById<TextView>(R.id.age_txt)
        age.setText(currentItem.age)*/