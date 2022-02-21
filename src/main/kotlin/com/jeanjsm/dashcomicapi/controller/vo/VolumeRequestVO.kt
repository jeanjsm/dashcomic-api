package com.jeanjsm.dashcomicapi.controller.vo

import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal
import java.time.LocalDate

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class VolumeRequestVO(
    val number: Int,
    val price: BigDecimal? = null,
    val dateAdded: LocalDate? = null,
    val amount: Int? = null
)
