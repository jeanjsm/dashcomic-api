package com.jeanjsm.dashcomicapi.domain.entity

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "volume")
data class Volume(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "id_comic")
    var comic: Comic,

    val number: Int,

    val price: BigDecimal = BigDecimal.ZERO,

    val dateAdded: LocalDate = LocalDate.now(),

    @Column(name = "cover_url")
    val coverUrl: String? = null
)
