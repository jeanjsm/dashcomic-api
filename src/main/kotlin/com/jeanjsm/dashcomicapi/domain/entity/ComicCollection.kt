package com.jeanjsm.dashcomicapi.domain.entity

import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "comic_collection")
data class ComicCollection(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToOne
    @JoinColumn(name = "id_collection")
    val collection: Collection,

    @ManyToOne
    @JoinColumn(name = "id_comic")
    val comic: Comic,

    @Column(name = "total_value")
    var totalValue: BigDecimal = BigDecimal.ZERO,

    val completed: Boolean = false,

    val createdAt: LocalDateTime = LocalDateTime.now(),

    val updatedAt: LocalDateTime = LocalDateTime.now()
) : Serializable
