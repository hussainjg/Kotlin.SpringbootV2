package com.coded.spring.ordering.service

import com.coded.spring.ordering.model.Order
import com.coded.spring.ordering.repository.OrderRepository
import com.coded.spring.ordering.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val userRepository: UserRepository
) {
    fun createOrder(userId: Long): Order {
        val user = userRepository.findById(userId).orElseThrow { Exception("User not found") }
        return orderRepository.save(Order(user = user))
    }

    fun getAllOrders(): List<Order> = orderRepository.findAll()
}