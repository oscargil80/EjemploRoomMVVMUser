package com.oscargil80.exampleroom.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.oscargil80.exampleroom.R
import com.oscargil80.exampleroom.data.User
import com.oscargil80.exampleroom.data.UserViewModel
import com.oscargil80.exampleroom.databinding.FragmentAddBinding


class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddBinding.inflate(inflater, container, false)


        mUserViewModel = ViewModelProvider(this).get((UserViewModel::class.java))

        binding.addBtn.setOnClickListener {
            insertDatatoDatabase()
        }


        return binding.root
    }

    private fun insertDatatoDatabase() {
        val firstName = binding.addFirstNameEt.text.toString()
        val lastName = binding.addLastNameEt.text.toString()
        val age = binding.addAgeEt.text
  if (inputCheck(firstName, lastName, age)){
      val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))
      mUserViewModel.addUser(user)
      Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT).show();
      findNavController().navigate(R.id.action_addFragment_to_listFragment)

  }else{
      Toast.makeText(requireContext(), "Please fill out fields!", Toast.LENGTH_SHORT).show();
  }
    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return  !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())

    }


}