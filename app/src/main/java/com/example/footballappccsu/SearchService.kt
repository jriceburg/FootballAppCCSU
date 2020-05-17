package com.example.footballappccsu

import retrofit2.Call
import retrofit2.http.*

interface SearchService {

    // POST request send twitter app details, and get back token needed for get requests
    @FormUrlEncoded
    @POST("oauth2/token")
    fun postCredentials(@Field("grant_type") grantType: String): Call<OAuthToken>


    // https://api.twitter.com/1.1/search/tweets.json?q= twitterdev%20new%20premium

    // GET request for search
    @GET("1.1/search/tweets.json")
    fun searchForTweets(@Query("q") query: String?,
               @Query("result_type") result_type: String,
               @Query("count") count: Int ): Call<SearchAPIData>?

    @GET("1.1/search/tweets.json")
    fun searchForTweets2(@Header("Authorization") authHeader: String,@Query("q") query: String?,
                        @Query("result_type") result_type: String,
                        @Query("count") count: Int ): Call<SearchAPIData>?



}