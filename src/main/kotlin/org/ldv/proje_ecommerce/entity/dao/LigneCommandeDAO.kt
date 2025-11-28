package org.ldv.proje_ecommerce.entity.dao

import org.ldv.proje_ecommerce.entity.LigneCommande
import org.springframework.data.jpa.repository.JpaRepository

interface LigneCommandeDAO : JpaRepository<LigneCommande, Long>