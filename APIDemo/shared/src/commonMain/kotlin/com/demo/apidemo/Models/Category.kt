package com.demo.apidemo.Models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Category (
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
        )