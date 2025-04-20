package com.coded.spring.ordering.model


import jakarta.persistence.*

@Entity
@Table(name = "profiles")
data class Profile(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true)
    val user: User = User(),
    val firstName : String = "",
    val lastName : String = "",
    val phoneNumber : String = ""

)


