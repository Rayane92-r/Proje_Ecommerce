package org.ldv.proje_ecommerce.entity

import jakarta.persistence.*

@Entity
data class Categorie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var nom: String = ""        // ⚠️ valeur par défaut obligatoire !
)
