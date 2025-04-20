package com.coded.spring.ordering.service

import com.coded.spring.ordering.model.User
import com.coded.spring.ordering.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getAllUsers(): List<User> = userRepository.findAll()

}