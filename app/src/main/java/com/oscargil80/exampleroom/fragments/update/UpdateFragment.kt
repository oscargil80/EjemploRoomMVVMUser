package com.oscargil80.exampleroom.fragments.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.oscargil80.exampleroom.R
import com.oscargil80.exampleroom.databinding.FragmentListBinding
import com.oscargil80.exampleroom.databinding.FragmentUpdateBinding


class UpdateFragment : Fragment() {

    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)

        return binding.root
    }


}