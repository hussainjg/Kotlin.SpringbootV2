package com.coded.spring.ordering.controller

import com.coded.spring.ordering.AppProperties
import com.coded.spring.ordering.pets.PetsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

    @RestController
    class HelloWorldController (
        private val petsProvider: PetsService,
        private val appProperties: AppProperties
        ){

        @GetMapping("/hello")
        fun helloWorld(): String {
            return "Hello World Welcome to my server!"
        }

        @PostMapping("/my-name")
        fun myName(@RequestBody request: NameRequest): NameResponse {
            return NameResponse(id = 1, name = request.name)
        }
        @GetMapping("/pets")
        fun getPets(): String {
            return petsProvider.listPets().toString().replace("[", "").replace("]", "")
        }
        @GetMapping("/welcome")
        fun welcome(): String {
            return if (appProperties.festiveMode) {
                appProperties.festiveMessage
            } else {
                "Welcome to Online Ordering by ${appProperties.companyName}"
            }
        }

        data class NameRequest(
            val name: String
        )

        data class NameResponse(
            val id: Int,
            val name: String
        )
    }