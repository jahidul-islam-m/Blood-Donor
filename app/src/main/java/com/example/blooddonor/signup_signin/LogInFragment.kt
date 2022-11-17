package com.example.blooddonor.signup_signin

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.blooddonor.BaseActivity
import com.example.blooddonor.DataClass.LoginReq
import com.example.blooddonor.DataClass.LoginResponse
import com.example.blooddonor.R
import com.example.blooddonor.RetrofitClient
import com.example.blooddonor.RetrofitClient.Companion.api
import com.example.blooddonor.databinding.FragmentLogInBinding
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInFragment : Fragment() {
    private var _binding: FragmentLogInBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val api=RetrofitClient.api
        buttonClickResponse()


    }


    private fun buttonClickResponse(): Unit {
        binding.signupBtn.setOnClickListener {

            findNavController().navigate(R.id.action_logInFragment_to_signUpFragment2)

        }

        binding.forgetpassBtn.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_forget1Fragment)
        }

        binding.loginBtn.setOnClickListener {
            val phone = binding.phonetxtInput.text.toString()
            val password = binding.passtxtInput.text.toString()
            if (phone != null && Patterns.PHONE.matcher(phone).matches()) {
                binding.phonetxtInputLayout.error = null

                if (password.length > 5) {
                    binding.progressbar.isVisible=true
                    binding.passtxtInputLayout.error = null

                    val loginReq=LoginReq(password,phone)

                    api.login(loginReq).enqueue(object :Callback<LoginResponse>{
                        override fun onResponse(
                            call: Call<LoginResponse>,
                            response: Response<LoginResponse>
                        ) {
                            if (response.isSuccessful){
                                binding.progressbar.isVisible=false
                                Toast.makeText(requireContext(), "Login Successfully", Toast.LENGTH_SHORT).show()
                                val intent = Intent(requireContext(), BaseActivity::class.java)
                                startActivity(intent)
                                requireActivity().finish()

                            }else{
                                binding.progressbar.isVisible=false
                                val jsonString = response.errorBody()?.charStream()!!.readText()
                                val jsonObject = JSONObject(jsonString)

                                if (jsonObject.has("status")) {
                                    val mess = jsonObject.getString("status")
                                    Toast.makeText(requireContext(), mess,Toast.LENGTH_SHORT).show()
                                }

                                if (jsonObject.has("data")) {
                                    val data = jsonObject.getJSONObject("data")

                                    if (data.has("phone")){
                                        val phone=data.getJSONArray("phone").getString(0)
                                        binding.phonetxtInputLayout.error=phone
                                    }




                                }

                            }
                        }

                        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                            Toast.makeText(requireContext(),"${t.message}", Toast.LENGTH_SHORT).show()
                            binding.progressbar.isVisible=false
                        }

                    })




                } else {
                    binding.passtxtInputLayout.error = "Please enter 6 digit password"
                }

            } else {
                binding.phonetxtInputLayout.error = "Enter valid phone number"
            }



        }

        binding.skipBtn.setOnClickListener {

            val intent=Intent(requireContext(),BaseActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

    }

}