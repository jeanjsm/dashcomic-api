package com.jeanjsm.dashcomicapi.controller.vo

import com.jeanjsm.dashcomicapi.domain.entity.ComicCollection
import java.io.Serializable
import java.math.BigDecimal

data class ComicCollectionVO(
    val id: Long,
    val idComic: Long,
    val name: String,
    val authorName: String? = null,
    val year: Int? = null,
    val coverUrl: String? = null,
    val totalValue: BigDecimal,
    val completed: Boolean
) : Serializable {
    constructor(comicCollection: ComicCollection) : this(
        id = comicCollection.id!!,
        idComic = comicCollection.comic.id!!,
        name = comicCollection.comic.name,
        authorName = comicCollection.comic.authorName,
        year = comicCollection.comic.year,
        coverUrl = comicCollection.comic.coverUrl,
        totalValue = comicCollection.totalValue,
        completed = comicCollection.completed
    )
}
