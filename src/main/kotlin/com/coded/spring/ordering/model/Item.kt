package com.coded.spring.ordering.model

import jakarta.persistence.*

@Entity
@Table(name = "items")
data class Item(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    val order: Order = Order(),

    val name: String = "",

    val quantity: Int = 1
) {
    constructor() : this(0, Order(), "", 1)
}