package com.coded.spring.ordering.authentication

import org.springframework.security.core.userdetails.*
import com.coded.spring.ordering.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val usersRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = usersRepository.findByUsername(username) ?: throw UsernameNotFoundException("User not found")

        return User.builder()
            .username(user.username)
            .password(user.password)
            .roles(user.role.toString())
            .build()
    }
}