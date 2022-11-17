package com.example.blooddonor.signup_signin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.blooddonor.BaseActivity
import com.example.blooddonor.R
import com.example.blooddonor.databinding.FragmentSignUp2Binding

class SignUp_2_Fragment : Fragment() {
    private var _binding:FragmentSignUp2Binding?=null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentSignUp2Binding.inflate(inflater,container,false)
        return binding.root

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dropdown()



        binding.skipBtn.setOnClickListener {

            val intent = Intent(requireContext(), BaseActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
        binding.nextBtn.setOnClickListener {
            findNavController().navigate(R.id.signup_3Fragment)

        }

        binding.loginBtn.setOnClickListener {

            findNavController().navigate(R.id.action_signUpDonorFragment_to_logInFragment)

        }


    }
    private fun dropdown(){

        val districtarray: Array<String> = resources.getStringArray(R.array.District)
        val districtAdapter =
            ArrayAdapter(requireContext(), R.layout.sample, R.id.textview, districtarray)
        binding.districtDropdownid.setAdapter(districtAdapter)


        val areaArray: Array<String> = resources.getStringArray(R.array.Area)
        val areaAdapter =
            ArrayAdapter(requireContext(), R.layout.sample, R.id.textview, areaArray)
        binding.areaDropdown.setAdapter(areaAdapter)


        val genderArray: Array<String> = resources.getStringArray(R.array.Gender)
        val genderAdapter =
            ArrayAdapter(requireContext(), R.layout.sample, R.id.textview, genderArray)
        binding.genderDropdown.setAdapter(genderAdapter)

        val relegionarray: Array<String> = resources.getStringArray(R.array.Religion)
        val relegionAdapter =
            ArrayAdapter(requireContext(), R.layout.sample, R.id.textview, relegionarray)
        binding.religionDropdown.setAdapter(relegionAdapter)


        val Bloodarray: Array<String> = resources.getStringArray(R.array.BloodGroup)
        val bloodadapter =
            ArrayAdapter(requireContext(), R.layout.sample, R.id.textview, Bloodarray)
        binding.religionDropdown.setAdapter(bloodadapter)




    }


}