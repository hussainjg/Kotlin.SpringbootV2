package com.coded.spring.ordering.repository

import com.coded.spring.ordering.model.MenuItem
import org.springframework.data.jpa.repository.JpaRepository

interface MenuItemRepository : JpaRepository<MenuItem, Long>