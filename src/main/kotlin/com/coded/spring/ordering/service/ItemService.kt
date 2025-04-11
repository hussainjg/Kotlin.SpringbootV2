package com.coded.spring.ordering.service

import com.coded.spring.ordering.model.Item
import com.coded.spring.ordering.repository.ItemRepository
import com.coded.spring.ordering.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val itemRepository: ItemRepository,
    private val orderRepository: OrderRepository
) {
    fun createItem(orderId: Long, name: String, quantity: Int): Item {
        val order = orderRepository.findById(orderId).orElseThrow { Exception("Order not found") }
        return itemRepository.save(Item(order = order, name = name, quantity = quantity))
    }

    fun getAllItems(): List<Item> = itemRepository.findAll()
}