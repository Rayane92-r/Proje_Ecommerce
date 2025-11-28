package org.ldv.proje_ecommerce.entity

import jakarta.persistence.*

@Entity
class Client (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(nullable = false)
    var nom: String,

    @Column(nullable = false)
    var email: String,

    @Column(nullable = false)
    var motDePasse: String,
)