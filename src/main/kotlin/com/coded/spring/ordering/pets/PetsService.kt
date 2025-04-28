package com.coded.spring.ordering.pets

import com.coded.spring.ordering.model.Pet
import jakarta.inject.Named

@Named
class PetsService(private val petsProvider: PetsProvider) {

    fun listPets() : List<Pet> = petsProvider.getPets()
}