package org.ldv.proje_ecommerce.admincontrollers

import org.ldv.proje_ecommerce.entity.Produit
import org.ldv.proje_ecommerce.entity.dao.ProduitDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.*

@Controller
@RequestMapping("/admin/produits")
open class AdminProduitController(
    private val produitDAO: ProduitDAO
) {

    @GetMapping
    open fun index(model: Model): String {
        model.addAttribute("produits", produitDAO.findAll())
        return "pageAdmin/produit/index"
    }

    @GetMapping("/create")
    open fun createForm(model: Model): String {
        model.addAttribute("produit", Produit())
        return "pageAdmin/produit/create"
    }

    @PostMapping("/create")
    open fun createSubmit(
        @ModelAttribute produit: Produit,
        @RequestParam("imageFile", required = false) imageFile: MultipartFile?,
        redirect: RedirectAttributes
    ): String {

        if (imageFile != null && !imageFile.isEmpty) {
            val uploadDir = Paths.get("uploads")
            Files.createDirectories(uploadDir)

            val fileName = UUID.randomUUID().toString() + "-" + (imageFile.originalFilename ?: "image.jpg")
            val destination = uploadDir.resolve(fileName)

            Files.copy(imageFile.inputStream, destination, StandardCopyOption.REPLACE_EXISTING)

            produit.imagePath = "/uploads/$fileName"
        }

        produitDAO.save(produit)
        redirect.addFlashAttribute("success", "Produit créé avec succès")
        return "redirect:/admin/produits"
    }

    @GetMapping("/edit/{id}")
    open fun editForm(@PathVariable id: Long, model: Model): String {
        val produit = produitDAO.findById(id).orElseThrow()
        model.addAttribute("produit", produit)
        return "pageAdmin/produit/edit"
    }

    @PostMapping("/edit/{id}")
    open fun editSubmit(
        @PathVariable id: Long,
        @ModelAttribute produit: Produit,
        @RequestParam("imageFile", required = false) imageFile: MultipartFile?,
        redirect: RedirectAttributes
    ): String {

        val existing = produitDAO.findById(id).orElseThrow()

        // garder l’ancienne image si rien n’est envoyé
        produit.id = id
        produit.imagePath = existing.imagePath

        if (imageFile != null && !imageFile.isEmpty) {
            val uploadDir = Paths.get("uploads")
            Files.createDirectories(uploadDir)

            val fileName = UUID.randomUUID().toString() + "-" + (imageFile.originalFilename ?: "image.jpg")
            val destination = uploadDir.resolve(fileName)

            Files.copy(imageFile.inputStream, destination, StandardCopyOption.REPLACE_EXISTING)

            produit.imagePath = "/uploads/$fileName"
        }

        produitDAO.save(produit)
        redirect.addFlashAttribute("success", "Produit modifié avec succès")
        return "redirect:/admin/produits"
    }

    @GetMapping("/delete/{id}")
    open fun delete(@PathVariable id: Long, redirect: RedirectAttributes): String {
        produitDAO.deleteById(id)
        redirect.addFlashAttribute("success", "Produit supprimé avec succès")
        return "redirect:/admin/produits"
    }
}
