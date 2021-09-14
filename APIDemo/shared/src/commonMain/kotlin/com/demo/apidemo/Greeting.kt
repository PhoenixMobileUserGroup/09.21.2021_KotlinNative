package com.demo.apidemo

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}