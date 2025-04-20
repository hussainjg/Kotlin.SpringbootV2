package com.coded.spring.ordering.repository

import com.coded.spring.ordering.model.Profile
import org.springframework.data.jpa.repository.JpaRepository

interface ProfileRepository : JpaRepository<Profile, Long> {
    fun findByUserId(userId: Long): Profile?
}