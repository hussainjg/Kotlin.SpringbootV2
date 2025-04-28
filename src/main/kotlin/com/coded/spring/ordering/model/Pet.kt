package com.coded.spring.ordering.model

import java.io.Serializable

data class Pet(
    val name: String,
    val type: String
) : Serializable