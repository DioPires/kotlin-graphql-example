package com.piresdio.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.piresdio.kotlingraphql.model.Review
import com.piresdio.kotlingraphql.model.Snack
import com.piresdio.kotlingraphql.repository.ReviewRepository
import com.piresdio.kotlingraphql.repository.SnackRepository
import org.springframework.stereotype.Component

@Component
class SnackQueryResolver(val snackRepository: SnackRepository, val reviewRepository: ReviewRepository): GraphQLQueryResolver {
    fun snacks(): List<Snack> {
        return snackRepository
                .findAll()
                .map {
                    it.reviews = getReviews(snackId = it.id)
                    it
                }
    }

    private fun getReviews(snackId: String): List<Review> {
        return reviewRepository.findBySnackId(snackId)
    }
}