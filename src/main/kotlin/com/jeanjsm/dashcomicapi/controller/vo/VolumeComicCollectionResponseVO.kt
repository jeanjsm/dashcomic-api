package com.jeanjsm.dashcomicapi.controller.vo

import com.jeanjsm.dashcomicapi.domain.entity.VolumeComicCollection
import java.math.BigDecimal

data class VolumeComicCollectionResponseVO(
    val id: Long? = null,
    val number: Int,
    val price: BigDecimal,
    val idComicCollection: Long? = null,
    val coverUrl: String? = null
) {
    constructor(volumeComicCollection: VolumeComicCollection) : this(
        id = volumeComicCollection.id,
        number = volumeComicCollection.number,
        price = volumeComicCollection.price,
        idComicCollection = volumeComicCollection.comicCollection.id,
        coverUrl = volumeComicCollection.comicCollection.coverUrl
    )
}
