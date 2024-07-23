package com.oscargil80.exampleroom.fragments.list

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
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
        setHasOptionsMenu(true)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ListAdapter(
            onClick = { user ->
            val action = listFragmentDirections.actionListFragmentToUpdateFragment(user)
                findNavController().navigate(action)
               // findNavController().navigate(R.id.action_listFragment_to_updateFragment)
            }
        )
         // recyclerview
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteAllUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("yes") { _, _ ->
            mUserViewModel.deleteAllUser()
            Toast.makeText(
                requireContext(),
                "Succesfully  removed all Users",
                Toast.LENGTH_SHORT
            ).show();

        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete all Users?")
        builder.setMessage("Are You sure you want to delete  all Users ?")
        builder.create().show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}