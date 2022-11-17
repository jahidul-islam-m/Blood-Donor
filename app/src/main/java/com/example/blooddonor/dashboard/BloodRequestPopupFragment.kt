package com.example.blooddonor.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.blooddonor.R
import com.example.blooddonor.databinding.FragmentBloodRequestPopupBinding

class BloodRequestPopupFragment : Fragment() {

    private var _binding:FragmentBloodRequestPopupBinding?=null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentBloodRequestPopupBinding.inflate(inflater,container,false)
        return binding.root
      }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.enterBtn.setOnClickListener {
            findNavController().navigate(R.id.action_bloodRequestPopupFragment_to_mainDashboardFragment)
        }

    }


}