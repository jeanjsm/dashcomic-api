package com.jeanjsm.dashcomicapi.controller.vo

import com.jeanjsm.dashcomicapi.domain.entity.Collection
import java.io.Serializable
import java.math.BigDecimal

data class CollectionVO(
    val id: Long? = null,
    val userId: Long,
    val totalAmount: Int?,
    val totalValue: BigDecimal?
): Serializable {
    constructor(collection: Collection) : this (
        id = collection.id,
        userId = collection.user.id,
        totalAmount = collection.totalAmount,
        totalValue = collection.totalValue
    )
}
