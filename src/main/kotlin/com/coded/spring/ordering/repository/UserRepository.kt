package com.coded.spring.ordering.repository

import com.coded.spring.ordering.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>