package com.jeanjsm.dashcomicapi.controller.vo

import com.jeanjsm.dashcomicapi.domain.entity.ComicCollection
import java.io.Serializable
import java.math.BigDecimal

data class ComicCollectionVO(
    val id: Long,
    val name: String? = null,
    val authorName: String? = null,
    val year: Int? = null,
    val coverUrl: String? = null,
    val totalValue: BigDecimal? = null,
    val completed: Boolean,
    val idMal: Long? = null,
    val idAnilist: Long? = null
) : Serializable {
    constructor(comicCollection: ComicCollection) : this(
        id = comicCollection.id!!,
        name = comicCollection.name,
        authorName = comicCollection.authorName,
        year = comicCollection.year,
        coverUrl = comicCollection.coverUrl,
        totalValue = comicCollection.totalValue,
        completed = comicCollection.completed,
        idMal = comicCollection.idMal,
        idAnilist = comicCollection.idAnilist
    )
}
