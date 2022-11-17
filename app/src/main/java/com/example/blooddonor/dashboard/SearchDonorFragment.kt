package com.example.blooddonor.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.blooddonor.R
import com.example.blooddonor.databinding.FragmentSearchDonorBinding

class SearchDonorFragment : Fragment() {
    private var _binding: FragmentSearchDonorBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSearchDonorBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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





        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_searchDonorFragment_to_mainDashboardFragment)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}