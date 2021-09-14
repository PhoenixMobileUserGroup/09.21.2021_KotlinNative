package com.demo.apidemo.Models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Weight(
    @SerialName("imperial")
    val imperial: String,
    @SerialName("metric")
    val metric: String,
)