package com.jeanjsm.dashcomicapi.controller.vo

import com.jeanjsm.dashcomicapi.integration.anilist.vo.Media

data class ComicResponseSearchVO(
    val title: String?,
    val coverUrl: String,
    val id: Int,
    val idMal: Int
) {
    constructor(media: Media) : this(
        title = media.title.romaji ?: media.title.english,
        coverUrl = media.coverImage.extraLarge,
        id = media.id,
        idMal = media.idMal
    )
}
