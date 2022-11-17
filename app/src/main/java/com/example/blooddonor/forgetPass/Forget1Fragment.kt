package com.example.blooddonor.forgetPass

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.blooddonor.DataClass.ResetReq
import com.example.blooddonor.DataClass.ResetResponse
import com.example.blooddonor.R
import com.example.blooddonor.RetrofitClient
import com.example.blooddonor.databinding.FragmentForget1Binding
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Forget1Fragment : Fragment() {
    private var _binding: FragmentForget1Binding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentForget1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val api = RetrofitClient.api



        binding.ResetBtn.setOnClickListener {
            val phone = binding.phonetxtInput.text.toString()

            if (phone!=null && Patterns.PHONE.matcher(phone).matches()) {


                val ResetReq = ResetReq(phone)
                api.forget(ResetReq).enqueue(object : Callback<ResetResponse> {
                    override fun onResponse(
                        call: Call<ResetResponse>,
                        response: Response<ResetResponse>
                    ) {
                        if (response.isSuccessful) {
                            Log.d(TAG, "onResponse: ${response.body()}")
                            Toast.makeText(
                                requireContext(),
                                "${response.message()}",
                                Toast.LENGTH_SHORT
                            ).show()

                            val directions = Forget1FragmentDirections.actionForget1FragmentToForget2Fragment(phone)

                            findNavController().navigate(directions)

                        } else {
                            Toast.makeText(
                                requireContext(),
                                "${response.message()}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<ResetResponse>, t: Throwable) {
                        Log.d(TAG, "onFailure: ${t.message}")
                        Toast.makeText(requireContext(), "${t.message}", Toast.LENGTH_SHORT).show()
                    }

                })
            }



        }

        binding.signupBtn.setOnClickListener {

            findNavController().navigate(R.id.action_forget1Fragment_to_signUpFragment2)

        }


    }

}