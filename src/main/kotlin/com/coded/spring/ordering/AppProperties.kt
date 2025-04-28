package com.coded.spring.ordering

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties
class AppProperties {
    lateinit var companyName: String
    var festiveMode: Boolean = false
    var festiveMessage: String = "Eidkom Mubarak"
    var festiveDiscount: Int = 20
}