package com.coded.spring.ordering.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

    @RestController
    class HelloWorldController {

        @GetMapping("/hello")
        fun helloWorld(): String {
            return "Hello World Welcome to my server!"
        }

        @PostMapping("/my-name")
        fun myName(@RequestBody request: NameRequest): NameResponse {
            return NameResponse(id = 1, name = request.name)
        }


        data class NameRequest(
            val name: String
        )

        data class NameResponse(
            val id: Int,
            val name: String
        )
    }