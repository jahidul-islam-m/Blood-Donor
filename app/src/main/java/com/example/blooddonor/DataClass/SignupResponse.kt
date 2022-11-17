package com.example.blooddonor.DataClass

import com.google.gson.annotations.SerializedName

data class SignupResponse(
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
        @SerializedName("token")
        val token: String?,
        @SerializedName("user")
        val user: User?
        ) {
        data class User(
            @SerializedName("created_at")
            val createdAt: String?,
            @SerializedName("email")
            val email: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("phone")
            val phone: String?,
            @SerializedName("profile")
            val profile: Profile?,
            @SerializedName("role")
            val role: String?,
            @SerializedName("status")
            val status: String?,
            @SerializedName("updated_at")
            val updatedAt: String?,
            @SerializedName("verify")
            val verify: String?
        ) {
            data class Profile(
                @SerializedName("address")
                val address: Any?,
                @SerializedName("area_id")
                val areaId: Any?,
                @SerializedName("available_donate")
                val availableDonate: String?,
                @SerializedName("available_donate_schedule")
                val availableDonateSchedule: Any?,
                @SerializedName("avatar")
                val avatar: Any?,
                @SerializedName("blood_group")
                val bloodGroup: Any?,
                @SerializedName("created_at")
                val createdAt: String?,
                @SerializedName("district_id")
                val districtId: Any?,
                @SerializedName("dob")
                val dob: Any?,
                @SerializedName("emergency_donate")
                val emergencyDonate: String?,
                @SerializedName("gender")
                val gender: Any?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("phone_publicly")
                val phonePublicly: String?,
                @SerializedName("religion")
                val religion: Any?,
                @SerializedName("updated_at")
                val updatedAt: String?,
                @SerializedName("user_id")
                val userId: Int?
            )
        }
    }
}