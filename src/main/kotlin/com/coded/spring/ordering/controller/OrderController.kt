package com.coded.spring.ordering.controller

import com.coded.spring.ordering.model.Order
import com.coded.spring.ordering.service.OrderService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrderController(private val orderService: OrderService) {

    @PostMapping("/{userId}")
    fun createOrder(@PathVariable userId: Long): Order {
        return orderService.createOrder(userId)
    }

    @GetMapping
    fun getAllOrders(): List<Order> {
        return orderService.getAllOrders()
    }
}