package com.example.blooddonor.DataClass


import com.google.gson.annotations.SerializedName

data class ResetResponse(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("statusCode")
    val statusCode: Int?
) {
    data class Data(
        @SerializedName("code")
        val code: String?,
        @SerializedName("phone")
        val phone: String?,
        @SerializedName("validate_till")
        val validateTill: String?
    )
}