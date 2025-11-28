package org.ldv.proje_ecommerce.visiteurcontrollers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping("/")
    fun index(): String = "pagesVisiteur/index"

    @GetMapping("/produits")
    fun produits(): String = "pagesVisiteur/produits"

    @GetMapping("/a-propos")
    fun aPropos(): String = "pagesVisiteur/a-propos"

    @GetMapping("/contact")
    fun contact(): String = "pagesVisiteur/contact"

    @GetMapping("/inscription")
    fun inscription(): String = "pagesVisiteur/inscription"

    @GetMapping("/rgpd")
    fun rgpd(): String = "pagesVisiteur/rgpd"

    @GetMapping("/panier")
    fun panier(): String = "pagesVisiteur/panier"

    @GetMapping("/connexion")
    fun connexion(): String = "pagesVisiteur/connexion"
}
