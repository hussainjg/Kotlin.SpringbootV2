package com.coded.spring.ordering

import com.coded.spring.ordering.model.User
import com.coded.spring.ordering.repository.UserRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import kotlin.test.assertEquals

@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@Autowired
	lateinit var restTemplate: TestRestTemplate

	@Autowired
	lateinit var userRepository: UserRepository

	@Test
	fun helloWorld() {
		val result = restTemplate.getForEntity("/hello", String::class.java)
		val expected = "Hello World"
		assertEquals(expected, actual = result.body)
		assertEquals(HttpStatus.OK, actual = result?.statusCode)
	}
	@Test
	fun testCreateUser() {

		val user = User(null, name = "Test", 17 ,username = "t1estusehr123", password = "test123")
		val result = restTemplate.postForEntity("/users/create",user ,String::class.java)

		assertEquals(HttpStatus.OK, actual = result?.statusCode)
	}

	@Test
	fun contextLoads() {

	}
}
