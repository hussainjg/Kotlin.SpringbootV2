package com.coded.spring.ordering.repository


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Long>

@Entity
@Table(name = "items")
data class Item(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    val order: com.coded.spring.ordering.repository.Order = Order(),

    val name: String = "",

    val quantity: Int = 1
) {
    constructor() : this(0, Order(), "", 1)
}