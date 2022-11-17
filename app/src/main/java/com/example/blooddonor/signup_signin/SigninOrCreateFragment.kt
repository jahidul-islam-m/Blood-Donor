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
import com.example.blooddonor.databinding.FragmentSigninOrCreateBinding


class SigninOrCreateFragment : Fragment() {

    private var _binding:FragmentSigninOrCreateBinding?=null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSigninOrCreateBinding.inflate(inflater,container,false)
        return binding.root
       }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //login btn
        binding.loginBtn.setOnClickListener {

            findNavController().navigate(R.id.action_signinOrCreateFragment_to_logInFragment)

        }
        //create account btn
        binding.createaccBtn.setOnClickListener {

            findNavController().navigate(R.id.action_signinOrCreateFragment_to_signUpFragment2)
        }

        binding.skipBtn.setOnClickListener {

            val intent = Intent(requireContext(), BaseActivity::class.java)
            startActivity(intent)
            requireActivity().finish()

        }




    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}