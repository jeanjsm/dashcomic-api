package com.jeanjsm.dashcomicapi.domain.entity

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "collection")
data class Collection(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToOne
    @JoinColumn(name = "id_user")
    val user: User,

    @Column(name = "total_value")
    var totalValue: BigDecimal = BigDecimal.ZERO,

    @Column(name = "total_amount")
    var totalAmount: Int = 0
)
