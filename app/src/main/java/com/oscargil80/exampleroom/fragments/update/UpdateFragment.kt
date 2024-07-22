package com.oscargil80.exampleroom.fragments.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.oscargil80.exampleroom.R
import com.oscargil80.exampleroom.databinding.FragmentListBinding
import com.oscargil80.exampleroom.databinding.FragmentUpdateBinding
import com.oscargil80.exampleroom.model.User
import com.oscargil80.exampleroom.viewmodel.UserViewModel


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewModel: UserViewModel

    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        Log.e("Pru", "LLEgo Aqui")
        binding.updateFirstNameEt.setText(args.currentUser.firstName.toString())
        binding.updateLastNameEt.setText(args.currentUser.lastName.toString())
        binding.updateAgeEt.setText(args.currentUser.age.toString())

        binding.updateBtn.setOnClickListener {
            updateItem()
        }

        return binding.root
    }

    private fun updateItem() {
        val  fistName = binding.updateFirstNameEt.text.toString()
        val  lastName = binding.updateLastNameEt.text.toString()
        val  age =  Integer.parseInt( binding.updateAgeEt.text.toString())

        if(inputCheck(fistName, lastName, binding.updateAgeEt.text)){
          val updateUser = User(args.currentUser.id, fistName, lastName, age)
         mUserViewModel.updateUser(updateUser)
            Toast.makeText(requireContext(), "Update Successfully!", Toast.LENGTH_SHORT).show();
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        }else{
            Toast.makeText(requireContext(), "Please Fill out all Fields!", Toast.LENGTH_SHORT).show();
        }

    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return  !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())

    }


}