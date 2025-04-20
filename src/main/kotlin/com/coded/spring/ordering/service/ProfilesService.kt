package com.coded.spring.ordering.service

import com.coded.spring.ordering.model.Profile
import com.coded.spring.ordering.model.User
import com.coded.spring.ordering.repository.ProfileRepository
import com.coded.spring.ordering.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProfileService(
    private val profileRepository: ProfileRepository,
    private val userRepository: UserRepository
) {

    fun createOrUpdateProfile(userId: Long, firstName: String, lastName: String, phoneNumber: String): Profile {
        validateInputs(firstName, lastName, phoneNumber)

        val user: User = userRepository.findById(userId)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "User not found") }

        val existing = profileRepository.findByUserId(userId)
        return if (existing != null) {
            val updated = existing.copy(firstName = firstName, lastName = lastName, phoneNumber = phoneNumber)
            profileRepository.save(updated)
        } else {
            val newProfile = Profile(user = user, firstName = firstName, lastName = lastName, phoneNumber = phoneNumber)
            profileRepository.save(newProfile)
        }
    }

    fun getProfile(userId: Long): Profile? = profileRepository.findByUserId(userId)

    private fun validateInputs(firstName: String, lastName: String, phoneNumber: String) {
        if (!firstName.matches(Regex("^[A-Za-z]+$"))) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "First name must contain letters only")
        }
        if (!lastName.matches(Regex("^[A-Za-z]+$"))) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Last name must contain letters only")
        }
        if (!phoneNumber.matches(Regex("^\\d{8}$"))) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Phone number must be exactly 8 digits with no letters")
        }
    }
}