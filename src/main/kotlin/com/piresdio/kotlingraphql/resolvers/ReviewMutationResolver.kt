package com.piresdio.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.piresdio.kotlingraphql.exception.ResourceNotFoundException
import com.piresdio.kotlingraphql.model.Review
import com.piresdio.kotlingraphql.repository.ReviewRepository
import com.piresdio.kotlingraphql.repository.SnackRepository
import org.springframework.stereotype.Component

@Component
class ReviewMutationResolver(private val reviewRepository: ReviewRepository, private val snackRepository: SnackRepository): GraphQLMutationResolver {
    fun newReview(snackId: String, rating: Int, text: String): Review {
        val review = Review(rating, text)
        return snackRepository
                .findById(snackId)
                .map { snack ->
                    review.snack = snack
                    reviewRepository.save(review)
                }.orElseThrow { ResourceNotFoundException("Snack with ID $snackId not found") }
    }
}