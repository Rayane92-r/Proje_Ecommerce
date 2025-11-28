package org.ldv.proje_ecommerce.entity.dao

import org.ldv.proje_ecommerce.entity.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientDAO : JpaRepository<Client, Long>