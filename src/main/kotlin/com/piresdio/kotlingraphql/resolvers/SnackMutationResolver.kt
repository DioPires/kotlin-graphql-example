package com.piresdio.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.piresdio.kotlingraphql.exception.ResourceNotFoundException
import com.piresdio.kotlingraphql.model.Snack
import com.piresdio.kotlingraphql.repository.SnackRepository
import org.springframework.stereotype.Component

@Component
class SnackMutationResolver(private val snackRepository: SnackRepository): GraphQLMutationResolver {
    fun newSnack(name: String, amount: Float): Snack {
        val snack = Snack(name, amount)
        return snackRepository.save(snack)
    }

    fun deleteSnack(snackId: String): Boolean {
        snackRepository.deleteById(snackId)
        return true
    }

    fun updateSnack(snackId: String, amount: Float): Snack {
        return snackRepository
                .findById(snackId)
                .map {
                    it.amount = amount
                    snackRepository.save(it)
                }.orElseThrow { ResourceNotFoundException("Snack with ID $snackId not found") }
    }
}