package com.coded.spring.ordering.controllers

import com.coded.spring.ordering.model.Profile
import com.coded.spring.ordering.service.ProfileService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/profile")
class ProfileController(
    private val profileService: ProfileService
) {

    @PostMapping
    fun createOrUpdateProfile(@RequestBody request: ProfileRequest): Profile {
        return profileService.createOrUpdateProfile(
            userId = request.userId,
            firstName = request.firstName,
            lastName = request.lastName,
            phoneNumber = request.phoneNumber
        )
    }

    @GetMapping("/{userId}")
    fun getProfile(@PathVariable userId: Long): Profile? =
        profileService.getProfile(userId)
}

data class ProfileRequest(
    val userId: Long,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String
)