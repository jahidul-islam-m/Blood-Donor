package com.example.blooddonor.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.blooddonor.R
import com.example.blooddonor.databinding.FragmentCreateBloodRequestBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class CreateBloodRequestFragment : Fragment() {
    private var _binding: FragmentCreateBloodRequestBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCreateBloodRequestBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.switchBtn.setOnClickListener{
            binding.selectdateLy.isVisible = !binding.switchBtn.isChecked
            binding.selecttimeLy.isVisible = !binding.selecttimeLy.isVisible
        }



        dropdown()
        datepicker()
        timepicker()
        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_createBloodRequestFragment_to_mainDashboardFragment)
        }

        binding.postBtn.setOnClickListener {
            findNavController().navigate(R.id.action_createBloodRequestFragment_to_bloodRequestPopupFragment)
        }


    }


    private fun datepicker() {

        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .build()

        binding.datepicker.setOnClickListener {
            datePicker.show(requireActivity().supportFragmentManager, "")

        }
        datePicker.addOnPositiveButtonClickListener {
            binding.datepicker.setText(datePicker.headerText)
        }
    }

    private fun timepicker(){

        val picker =
            MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(10)
                .setTitleText("Select time")
                .build()

        binding.timepicker.setOnClickListener {

            picker.show(requireActivity().supportFragmentManager,"")

            picker.addOnPositiveButtonClickListener {

            }


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

        val hospitalArray: Array<String> = resources.getStringArray(R.array.Hospital)
        val hospitalAdapter =
            ArrayAdapter(requireContext(), R.layout.sample, R.id.textview, hospitalArray)
        binding.selectHospitalDropdown.setAdapter(hospitalAdapter)



    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }

}