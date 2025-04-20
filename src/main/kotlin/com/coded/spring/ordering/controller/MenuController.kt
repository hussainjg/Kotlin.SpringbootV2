package com.coded.spring.ordering.controller

import com.coded.spring.ordering.model.MenuItem
import com.coded.spring.ordering.service.MenuService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/menu")
class MenuController(
    private val menuService: MenuService
) {

    @GetMapping
    fun getMenu(): List<MenuItem> = menuService.getAllMenuItems()

    @PostMapping
    fun addMenuItem(@RequestBody menuItem: MenuItem): MenuItem {
        return menuService.addMenuItem(menuItem)
    }
}