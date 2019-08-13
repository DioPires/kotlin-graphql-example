package com.piresdio.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.piresdio.kotlingraphql.model.Review
import com.piresdio.kotlingraphql.repository.ReviewRepository
import org.springframework.stereotype.Component

@Component
class ReviewQueryResolver(private val reviewRepository: ReviewRepository): GraphQLQueryResolver {
    fun reviews(snackId: String): List<Review> {
        return reviewRepository.findBySnackId(snackId)
    }
}