package org.ldv.proje_ecommerce.entity

import jakarta.persistence.*

@Entity
class LigneCommande (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(nullable = false)
    var quantite: Int,

    @Column(nullable = false)
    var produitId: Long,

    @Column(nullable = false)
    var prixUnitaire: Double,
)