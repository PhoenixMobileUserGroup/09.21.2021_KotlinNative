package com.demo.apidemo.Models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Breed (
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("temperament")
    val temperament: String,
    @SerialName("life_span")
    val lifeSpan: String,
    @SerialName("alt_name")
    val altName: String,
    @SerialName("wikipedia_url")
    val wikipediaUrl: String,
    @SerialName("origin")
    val origin: String,
    @SerialName("weight_imperial")
    val weightImperial: String? = null,
    @SerialName("weight")
    val weight: Weight? = null,
    @SerialName("experimental")
    val experimental: Int,
    @SerialName("hairless")
    val hairless: Int,
    @SerialName("natural")
    val natural: Int,
    @SerialName("rare")
    val rare: Int,
    @SerialName("rex")
    val rex: Int,
    @SerialName("suppress_tail")
    val suppressTail: Int,
    @SerialName("short_legs")
    val shortLegs: Int,
    @SerialName("hypoallergenic")
    val hypoallergenic: Int,
    @SerialName("adaptability")
    val adaptability: Int,
    @SerialName("affection_level")
    val affectionLevel: Int,
    @SerialName("country_code")
    val countryCode: Int,
    @SerialName("child_friendly")
    val childFriendly: Int,
    @SerialName("dog_friendly")
    val dogFriendly: Int,
    @SerialName("energy_level")
    val energyLevel: Int,
    @SerialName("grooming")
    val grooming: Int,
    @SerialName("health_issues")
    val healthIssues: Int,
    @SerialName("intelligence")
    val intelligence: Int,
    @SerialName("shedding_level")
    val sheddingLevel: Int,
    @SerialName("social_needs")
    val socialNeeds: Int,
    @SerialName("stranger_friendly")
    val strangerFriendly: Int,
    @SerialName("vocalisation")
    val vocalisation: Int,
    @SerialName("cfa_url")
    val cfaURL: String?,
    @SerialName("vetstreet_url")
    val vetStreetUrl: String?
        )