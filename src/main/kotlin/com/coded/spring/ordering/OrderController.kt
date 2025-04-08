package com.coded.spring.ordering

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController // Optional: makes your API cleaner
class OrderController(val orderRepository: OrderRepository) {

    @PostMapping("/orders")
    fun submitOrder(@RequestBody request: OrderRequest): Order {
        val order = Order(
            username = request.username,
            resturant = request.resturant,
            items = request.items
        )
        return orderRepository.save(order)
    }

    @GetMapping("/listOrders")
    fun listOrders(): List<Order> {
        return orderRepository.findAll()
    }
}

data class OrderRequest(
    val username: String,
    val resturant: String,
    val items: List<String>
)