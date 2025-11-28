package org.ldv.proje_ecommerce.entity.dao

import org.ldv.proje_ecommerce.entity.Produit
import org.springframework.data.jpa.repository.JpaRepository

interface ProduitDAO : JpaRepository<Produit, Long>