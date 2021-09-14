package com.demo.apidemo.Models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Image (
    @SerialName("id")
    val id: String,
    @SerialName("url")
    val url: String,
    @SerialName("width")
    val width: Int,
    @SerialName("height")
    val height: Int,
    @SerialName("categories")
    val categories: List<Category>? = null,
    @SerialName("breeds")
    val breeds: List<Breed>? = null
    )