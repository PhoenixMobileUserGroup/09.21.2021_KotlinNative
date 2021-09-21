package com.demo.apidemo.Controllers

import com.demo.apidemo.Models.Image
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*


class CatApiController {

    val httpClient = HttpClient {
        expectSuccess = false
        io.ktor.client.features.observer.ResponseObserver { response ->
            println("HTTP status: ${response.status.value}")
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })
        }
    }


    @Throws(Exception::class) suspend fun getImage(): List<Image> {
        return httpClient.request {
            url("https://api.thecatapi.com/v1/images/search")
            method = HttpMethod.Get
            headers {
                append("x-api-key", "<YOUR API KEY HERE>")
            }
        }
    }

}