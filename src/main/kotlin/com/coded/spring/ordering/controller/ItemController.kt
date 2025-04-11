package com.coded.spring.ordering.controller

import com.coded.spring.ordering.model.Item
import com.coded.spring.ordering.service.ItemService
import org.springframework.web.bind.annotation.*

@RestController
class ItemController(private val itemService: ItemService) {

    @PostMapping("/items/{orderId}")
    fun createItem(
        @PathVariable orderId: Long,
        @RequestBody body: Map<String, Any>
    ): Item {
        val name = body["name"] as? String ?: throw Exception("name is required")
        val quantity = (body["quantity"] as? Int) ?: 1
        return itemService.createItem(orderId, name, quantity)
    }

    @GetMapping("/items")
    fun getAllItems(): List<Item> = itemService.getAllItems()
}