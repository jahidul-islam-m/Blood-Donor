package com.example.blooddonor.signup_signin

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.example.blooddonor.API
import com.example.blooddonor.DataClass.SignUpRequest
import com.example.blooddonor.DataClass.SignupResponse
import com.example.blooddonor.R
import com.example.blooddonor.RetrofitClient
import com.example.blooddonor.databinding.FragmentSignUpBinding
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    
    companion object{
        private const val TAG = "SignUpFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val api=RetrofitClient.api
        //signup validation
        binding.nametxtInput.doOnTextChanged() { text, start, before, count ->
            if (text != null && text.toString().matches("^[A-Za-z ]+$".toRegex()) && text.length > 3) {
                binding.nametxtInputLayout.error = null

            } else {
                binding.nametxtInputLayout.error = "Enter valid name"
            }
        }

        binding.phonetxtInput.doOnTextChanged { text, start, before, count ->
            if (text!=null && Patterns.PHONE.matcher(text).matches()){
                binding.phonetxtInputLayout.error=null
            }else{
                binding.phonetxtInputLayout.error=null
            }

        }

        binding.emailtxtInput.doOnTextChanged { text, start, before, count ->

            if (text!=null && Patterns.EMAIL_ADDRESS.matcher(text).matches()){
                binding.emailtxtInputLayout.error=null
            }
            else{
                binding.emailtxtInputLayout.error="Enter valid email"
            }
        }

        signupvalidation(api)




        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment2_to_logInFragment)

        }

    }


    private fun signupvalidation(api:API){
        binding.nextBtn.setOnClickListener {

            val name = binding.nametxtInput.text.toString()
            val phone = binding.phonetxtInput.text.toString()
            val email = binding.emailtxtInput.text.toString()
            val password = binding.passtxtInput.text.toString()
            val confirmpassword = binding.confirmpasstxtInput.text.toString()

            if ((name != null && name.toString()
                    .matches("^[A-Za-z ]+$".toRegex()) && name.length > 3)
            ) {
                binding.nametxtInputLayout.error = null

                if (phone!=null && Patterns.PHONE.matcher(phone).matches()) {
                    binding.phonetxtInputLayout.error = null

                    if (email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        binding.emailtxtInputLayout.error = null

                        if (password.length > 5) {
                            binding.passtxtInputLayout.error = null
                            if (password == confirmpassword) {
                                binding.progressbar.isVisible=true
                                binding.confirmpasstxtInputLayout.error = null

                                val signuprequest=SignUpRequest(email,name,password,confirmpassword,phone)
                                api.signup(signuprequest).enqueue(object :Callback<SignupResponse>{
                                    override fun onResponse(
                                        call: Call<SignupResponse>,
                                        response: Response<SignupResponse>
                                    ) {
                                        if (response.isSuccessful){
                                            binding.progressbar.isVisible=false
                                            Toast.makeText(requireContext(), "${response.body()?.message}", Toast.LENGTH_SHORT).show()
                                            Log.d("TAG", "onResponse: ${response.body()}")
                                            findNavController().navigate(R.id.action_signUpFragment2_to_signUpDonorFragment)

                                        }else{
                                            binding.progressbar.isVisible=false
                                            val jsonString = response.errorBody()?.charStream()!!.readText()
                                            val jsonObject = JSONObject(jsonString)
                                            if (jsonObject.has("status")) {
                                                val mess = jsonObject.getString("status")
                                                Toast.makeText(requireContext(), mess,Toast.LENGTH_SHORT).show()
                                            }

                                            if (jsonObject.has("name")) {

                                                val name=jsonObject.getJSONArray("name").getString(0)
                                                binding.nametxtInputLayout.error=name

                                            }

                                            if (jsonObject.has("data")) {
                                                val data = jsonObject.getJSONObject("data")

                                                if (data.has("phone")){
                                                    val phone=data.getJSONArray("phone").getString(0)
                                                    binding.phonetxtInputLayout.error=phone
                                                }

                                                if (data.has("email")) {
                                                    val email = data.getJSONArray("email").getString(0)
                                                    binding.emailtxtInputLayout.error = email
                                                }


                                            }

                                        }
                                    }

                                    override fun onFailure(
                                        call: Call<SignupResponse>,
                                        t: Throwable
                                    ) {
                                        binding.progressbar.isVisible=false
                                        Toast.makeText(requireContext(), "${t.message}", Toast.LENGTH_SHORT)
                                            .show()
                                        Log.d("TAG", "onFailure: ${t.message}")
                                         }


                                })

                            } else {
                                binding.confirmpasstxtInputLayout.error =
                                    "Password and confirm password don,t match"
                            }

                        } else {
                            binding.passtxtInputLayout.error = "Enter 6 digit password"
                        }


                    } else {
                        binding.emailtxtInputLayout.error = "Enter valid email"
                    }


                } else {
                    binding.phonetxtInputLayout.error = "Enter your valid Phone number"
                }
            } else {
                binding.nametxtInputLayout.error = "Enter valid name"
            }
        }


    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}