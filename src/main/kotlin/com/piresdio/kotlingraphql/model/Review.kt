package com.piresdio.kotlingraphql.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "reviews")
data class Review(var rating: Int, var text: String, @Id val id: String = UUID.randomUUID().toString()): AuditModel() {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "snack_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    var snack: Snack? = null
}