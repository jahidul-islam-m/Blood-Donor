package com.example.blooddonor.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blooddonor.Adapter.SeekersAdapter
import com.example.blooddonor.R
import com.example.blooddonor.databinding.FragmentSeekerBinding


class SeekerFragment : Fragment() {
private var _binding:FragmentSeekerBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentSeekerBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adaperseekers=SeekersAdapter()
        binding.seekeritemRecyclerview.apply {
            adapter=adaperseekers
            layoutManager=GridLayoutManager(requireContext(),2,RecyclerView.VERTICAL,false)

        }
        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_seekerFragment_to_mainDashboardFragment)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}