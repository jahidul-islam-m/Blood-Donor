package com.example.blooddonor

import com.example.blooddonor.DataClass.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface API {

    @POST("auth/register")
    fun signup(
        @Body SignupRequest: SignUpRequest
    ): Call<SignupResponse>

    @POST("auth/login")

    fun login(
        @Body LoginReq :LoginReq
    ):Call<LoginResponse>

    @POST("auth/reset-request")
    fun forget(

        @Body ResetReq:ResetReq

    ):Call<ResetResponse>

    @POST("/auth/reset-otp-verify")
    fun verify(
        @Body Verify: Verify
    )


    @POST("auth/reset-new-password")
    fun newpassword(
        @Body NewPassword:NewPassword
    )

}