package com.coded.spring.ordering.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    var age: Int,

    var username: String,
    var password: String,

    @Enumerated(EnumType.STRING)
    val role: Roles = Roles.USER

){
    constructor() : this(null, "name", 0, "username", "password", Roles.USER)
}

enum class Roles {
    USER, ADMIN
}