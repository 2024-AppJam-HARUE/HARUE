package com.example.harue.ui.calender

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harue.R
import com.example.harue.databinding.FragmentCalenderBinding

class CalenderFragment : Fragment(), OnClickCompleteListener {

    private var _binding: FragmentCalenderBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val celenderViewModel =
            ViewModelProvider(this).get(CelenderViewModel::class.java)

        _binding = FragmentCalenderBinding.inflate(inflater, container, false)
        val root: View = binding.root
        initCalenderRecyclerView()

        return root
    }
    lateinit var adapter : CalenderRecyclerAdapta
    private fun initCalenderRecyclerView() {
        adapter = CalenderRecyclerAdapta()
        adapter.callback = { position ->
            findNavController().navigate(R.id.action_navigation_calender_to_calenderClear)
        }
        with(binding) {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onClick(content: String) {
        findNavController().navigate(R.id.action_navigation_calender_to_calenderClear)
    }
}

interface OnClickCompleteListener {
    fun onClick(content: String)
}