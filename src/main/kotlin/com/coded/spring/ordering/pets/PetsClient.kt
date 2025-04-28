package com.coded.spring.ordering.pets

import com.coded.spring.ordering.model.Pet
import org.springframework.stereotype.Component

@Component
class PetsClient {

    fun getPets(): List<Pet> {
        return listOf(
            Pet(name = "Bella", "Dog"),
            Pet(name = "Charlie", "Cat"),
            Pet(name = "Luna", "Bird")
        )
    }
}