package com.coded.spring.ordering.controller

import com.coded.spring.ordering.model.User
import com.coded.spring.ordering.repository.UserRepository
import com.coded.spring.ordering.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService,
                     private val userRepository: UserRepository,
                     private val passwordEncoder: PasswordEncoder
) {


    @PostMapping("/create")
    fun createUser(@RequestBody user: User): User {
        val hashedPassword = passwordEncoder.encode(user.password)
        val newUser = user.copy(password = hashedPassword)

        if (userRepository.findByUsername(user.username) != null) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists") as Throwable
        }

        return userRepository.save(newUser)
    }
    @PostMapping("/getAll")
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }
}