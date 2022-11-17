package com.example.blooddonor.signup_signin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.blooddonor.BaseActivity
import com.example.blooddonor.R
import com.example.blooddonor.databinding.FragmentSignup3Binding

class Signup_3Fragment : Fragment() {
    private var _binding:FragmentSignup3Binding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentSignup3Binding.inflate(inflater,container,false)
      return  binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.action_signup_3Fragment_to_logInFragment)

        }

        binding.completeBtn.setOnClickListener {


           val intent= Intent(requireContext(),BaseActivity::class.java)

            startActivity(intent)
            requireActivity().finish()



        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null

    }

}