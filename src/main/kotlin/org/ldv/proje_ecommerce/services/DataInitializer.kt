package org.ldv.proje_ecommerce.services

import org.ldv.proje_ecommerce.entity.Categorie
import org.ldv.proje_ecommerce.entity.Produit
import org.ldv.proje_ecommerce.entity.dao.CategorieDAO
import org.ldv.proje_ecommerce.entity.dao.ProduitDAO
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


@Component
class DataInitializer(
    private val categorieDAO: CategorieDAO,
    private val produitDAO: ProduitDAO
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        // Si la base contient déjà des données, on ne fait rien
        if (categorieDAO.count() > 0 || produitDAO.count() > 0) {
            println("📦 Données déjà présentes, initialisation ignorée.")
            return
        }

        println("🚀 Initialisation des données...")

        // === Catégories ===
        val catSport = Categorie(nom = "Sport")
        val catVetement = Categorie(nom = "Vêtements")

        categorieDAO.saveAll(listOf(catSport, catVetement))

        // === Produits ===
        val prodBallon = Produit(
            nom = "Ballon de foot",
            prix = 29.99,
            description = "Ballon officiel taille 5",
            stock = 50,
            image = "/img/ballon.png",
            categorie = catSport
        )

        val prodChaussures = Produit(
            nom = "Chaussures running",
            prix = 79.99,
            description = "Chaussures légères et respirantes",
            stock = 25,
            image = "/img/chaussures.png",
            categorie = catSport
        )

        produitDAO.saveAll(listOf(prodBallon, prodChaussures))

        println("✅ Données initiales insérées :")
        println(" - ${categorieDAO.count()} catégories")
        println(" - ${produitDAO.count()} produits")
    }
}
