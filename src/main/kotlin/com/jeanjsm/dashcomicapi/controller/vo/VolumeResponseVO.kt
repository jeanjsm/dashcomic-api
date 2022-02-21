package com.jeanjsm.dashcomicapi.controller.vo

import com.jeanjsm.dashcomicapi.domain.entity.Volume
import java.math.BigDecimal
import java.time.LocalDate

data class VolumeResponseVO(
    val id: Long,
    val idComic: Long,
    val number: Int,
    val price: BigDecimal,
    val dateAdded: LocalDate,
    val coverUrl: String? = null
) {
    constructor(volume: Volume) : this(
        id = volume.id!!,
        idComic = volume.comic.id!!,
        number = volume.number,
        price = volume.price,
        dateAdded = volume.dateAdded,
        coverUrl = volume.coverUrl
    )
}
