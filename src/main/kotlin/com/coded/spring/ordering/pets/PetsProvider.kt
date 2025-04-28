package com.coded.spring.ordering.pets

import com.coded.spring.ordering.model.Pet
import com.coded.spring.ordering.serverCache
import jakarta.inject.Named

@Named
class PetsProvider(
    private val client: PetsClient) {

    fun getPets(): List<Pet> {
        val cachedPets = petsCache["pets"]
        if (cachedPets?.size == 0 || cachedPets == null) {
            println("No pets found, caching new data...")
            val pets = client.getPets()
            petsCache.put("pets", pets)
            return pets
        }
        println("returning ${cachedPets.size} pets")
        return petsCache["pets"] ?: listOf()
    }
}

val petsCache = serverCache.getMap<String, List<Pet>>("pets")