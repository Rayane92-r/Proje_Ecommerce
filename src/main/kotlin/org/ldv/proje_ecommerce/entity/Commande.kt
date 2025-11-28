package org.ldv.proje_ecommerce.entity

import jakarta.persistence.*

@Entity
class Commande (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(nullable = false)
    var client: Long,

    @Column(nullable = false)
    var dateCommande: String,

    @Column(nullable = false)
    var total: Float,

    @Column
    var statut: String,
)