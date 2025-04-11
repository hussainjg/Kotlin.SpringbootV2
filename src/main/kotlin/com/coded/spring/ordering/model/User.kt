package com.coded.spring.ordering.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val username: String = "",
    val age: Int = 0
) {
    constructor() : this(0, "", 0)
}