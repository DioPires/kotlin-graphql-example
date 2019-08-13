package com.piresdio.kotlingraphql.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "snacks")
data class Snack(var name: String, var amount: Float, @Id val id: String = UUID.randomUUID().toString()): AuditModel() {
   @Transient
   var reviews: List<Review> = emptyList()
}