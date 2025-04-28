package com.coded.spring.ordering.controller

import com.coded.spring.ordering.AppProperties
import com.coded.spring.ordering.model.MenuItem
import com.coded.spring.ordering.service.MenuService
import com.coded.spring.ordering.service.OrderService
import org.springframework.web.bind.annotation.*
import kotlin.div


@RestController
@RequestMapping("/menu")
class MenuController(
    private val menuService: MenuService,
    private val appProperties: AppProperties,
    private val menuItems: List<MenuItem>
) {

    @GetMapping
    fun getMenu(): List<MenuItem> {
        return if (appProperties.festiveMode) {
            menuItems.map {
                val discountedPrice = it.price * (1 - appProperties.festiveDiscount / 100.0)
                it.copy(price = String.format("%.2f", discountedPrice).toDouble())
            }
        } else {
            menuItems
        }
    }

    @PostMapping
    fun addMenuItem(@RequestBody menuItem: MenuItem): MenuItem {
        return menuService.addMenuItem(menuItem)
    }
}