package com.oscargil80.exampleroom.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.oscargil80.exampleroom.R
import com.oscargil80.exampleroom.viewmodel.UserViewModel
import com.oscargil80.exampleroom.databinding.FragmentListBinding


class listFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ListAdapter(
            onClick = { user ->
            val action = listFragmentDirections.actionListFragmentToUpdateFragment(user)
                findNavController().navigate(R.id.action_listFragment_to_updateFragment)
            }
        )

        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })

        binding.floatActionButton.setOnClickListener {

            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}