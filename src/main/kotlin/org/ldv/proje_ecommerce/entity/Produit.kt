package org.ldv.proje_ecommerce.entity

import jakarta.persistence.*

@Entity
data class Produit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var nom: String = "",
    var description: String = "",
    var prix: Double = 0.0,
    var stock: Int = 0,

    // CHAMP CORRIGÉ
    var imagePath: String? = null,

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    var categorie: Categorie? = null,
    val image: String
)
