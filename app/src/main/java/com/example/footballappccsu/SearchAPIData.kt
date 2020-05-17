package com.example.footballappccsu



data class SearchAPIData(
    val statuses : List<SearchResults>
)

data class SearchResults(
    val text : String,
    val created_at : String,
    val user : User,
    val retweet_count : Int,
    val favorite_count : Int
)

data class User(
    val name : String,
    val screen_name : String,
    val profile_image_url_https : String

){
    fun handle(): String{
    return "@${this.screen_name}"
}}