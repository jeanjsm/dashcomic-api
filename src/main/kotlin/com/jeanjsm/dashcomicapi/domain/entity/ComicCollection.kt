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

    @Column(name = "name")
    val name: String,

    @Column(name = "author_name")
    val authorName: String? = null,

    @Column(name = "year")
    val year: Int? = null,

    @Column(name = "cover_url")
    val coverUrl: String? = null,

    @Column(name = "total_value")
    var totalValue: BigDecimal = BigDecimal.ZERO,

    val completed: Boolean = false,

    @Column(name = "id_mal", nullable = true)
    val idMal: Long? = null,

    @Column(name = "id_anilist", nullable = true)
    val idAnilist: Long? = null,

    val createdAt: LocalDateTime = LocalDateTime.now(),

    val updatedAt: LocalDateTime = LocalDateTime.now()
) : Serializable
