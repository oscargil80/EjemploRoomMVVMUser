package com.oscargil80.exampleroom.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.oscargil80.exampleroom.R
import com.oscargil80.exampleroom.databinding.FragmentListBinding


class listFragment : Fragment() {

    private var _binding:FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListBinding.inflate(inflater, container, false)

        binding.floatActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

      return  binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}