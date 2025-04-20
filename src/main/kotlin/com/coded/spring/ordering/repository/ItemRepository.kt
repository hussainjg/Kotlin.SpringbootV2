package com.coded.spring.ordering.repository


import com.coded.spring.ordering.model.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Long>

