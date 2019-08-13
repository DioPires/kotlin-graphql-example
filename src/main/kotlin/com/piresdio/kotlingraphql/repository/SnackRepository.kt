package com.piresdio.kotlingraphql.repository

import com.piresdio.kotlingraphql.model.Snack
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SnackRepository: JpaRepository<Snack, String>