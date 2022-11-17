package com.example.blooddonor.forgetPass

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.blooddonor.R
import com.example.blooddonor.databinding.FragmentForget2Binding
import com.example.blooddonor.databinding.FragmentSignUp2Binding


class Forget2Fragment : Fragment() {
    private var _binding:FragmentForget2Binding?=null
    private val binding get() = _binding!!

    private val args by navArgs<Forget2FragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentForget2Binding.inflate(inflater,container,false   )
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.continueBtn.setOnClickListener {

            findNavController().navigate(R.id.action_forget2Fragment_to_forget3Fragment)


        }



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}