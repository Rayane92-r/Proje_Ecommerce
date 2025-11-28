package org.ldv.proje_ecommerce.admincontrollers

import org.ldv.proje_ecommerce.entity.Categorie
import org.ldv.proje_ecommerce.entity.dao.CategorieDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
open class AdminCategorieController(
    val categorieDAO: CategorieDAO
) {

    // --- INDEX ---
    @GetMapping("/admin/categories")
    fun index(model: Model): String {
        val categories = categorieDAO.findAll()
        model.addAttribute("categories", categories)
        return "pageAdmin/categorie/index"
    }

    // --- CREATE (GET) ---
    @GetMapping("/admin/categories/create")
    fun createForm(model: Model): String {
        model.addAttribute("categorie", Categorie())
        return "pageAdmin/categorie/create"
    }

    // --- CREATE (POST) ---
    @PostMapping("/admin/categories/create")
    fun createSubmit(
        @ModelAttribute categorie: Categorie,
        redirect: RedirectAttributes
    ): String {
        categorieDAO.save(categorie)
        redirect.addFlashAttribute("success", "Catégorie créée avec succès")
        return "redirect:/admin/categories"
    }

    // --- EDIT (GET) ---
    @GetMapping("/admin/categories/edit/{id}")
    fun editForm(@PathVariable id: Long, model: Model): String {
        val categorie = categorieDAO.findById(id).orElseThrow()
        model.addAttribute("categorie", categorie)
        return "pageAdmin/categorie/edit"
    }

    // --- EDIT (POST) ---
    @PostMapping("/admin/categories/edit/{id}")
    fun editSubmit(
        @PathVariable id: Long,
        @ModelAttribute categorie: Categorie,
        redirect: RedirectAttributes
    ): String {
        categorie.id = id
        categorieDAO.save(categorie)
        redirect.addFlashAttribute("success", "Catégorie modifiée avec succès")
        return "redirect:/admin/categories"
    }
}
