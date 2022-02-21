package com.jeanjsm.dashcomicapi.domain.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "comic")
data class Comic(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "author_name")
    val authorName: String? = null,

    @Column(name = "year")
    val year: Int? = null,

    @Column(name = "cover_url")
    val coverUrl: String? = null
)
