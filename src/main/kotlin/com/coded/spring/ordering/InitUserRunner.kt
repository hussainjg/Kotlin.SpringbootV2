package com.coded.spring.ordering

import com.coded.spring.ordering.model.Roles
import com.coded.spring.ordering.model.User
import com.coded.spring.ordering.repository.*
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
class InitUserRunner {
    @Bean
    fun initUsers(userRepository: UserRepository, passwordEncoder: PasswordEncoder) = CommandLineRunner {
        val user = User(
            name = "HelloUser",
            username = "testuser",
            password = passwordEncoder.encode("password123"),
            age = 18,
            role = Roles.USER
        )
        if (userRepository.findByUsername(user.username) == null) {
            println("Creating user ${user.username}")
            userRepository.save(user)
        } else  {
            println("User ${user.username} already exists")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args).close()
}