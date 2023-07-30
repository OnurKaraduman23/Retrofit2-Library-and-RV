package com.example.retrofit_deneme

import com.google.gson.annotations.SerializedName

data class MyDataItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)