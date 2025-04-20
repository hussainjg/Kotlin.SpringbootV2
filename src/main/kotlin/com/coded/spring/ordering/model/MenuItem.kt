package com.coded.spring.ordering.model

import jakarta.persistence.*

@Entity
@Table(name = "menu_items")
data class MenuItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String = "",

    val description: String = "",

    val price: Double = 0.0
)