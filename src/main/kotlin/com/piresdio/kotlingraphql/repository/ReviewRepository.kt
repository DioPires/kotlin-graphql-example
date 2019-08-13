package com.piresdio.kotlingraphql.repository

import com.piresdio.kotlingraphql.model.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository: JpaRepository<Review, String> {
    fun findBySnackId(id: String): List<Review>
}