package com.example.footballappccsu

import com.google.gson.annotations.SerializedName

data class OAuthToken(

    @SerializedName("access_token")
    var accessToken: String,

    @SerializedName("token_type")
    var tokenType: String
)

