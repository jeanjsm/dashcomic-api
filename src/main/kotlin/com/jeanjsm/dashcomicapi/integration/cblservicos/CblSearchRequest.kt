package com.jeanjsm.dashcomicapi.integration.cblservicos

data class CblSearchRequest(
    val count: Boolean = true,
//    val facets: List<String>? = null,
//    val filter: String? = null,
//    val orderBy: String? = null,
//    val queryType: String? = null,
    val search: String,
    val searchFields: String = "FormattedKey,RowKey",
//    val searchMode: String? = null,
//    val select: String? = null,
    val skip: Int = 0,
    val top: Int = 15
)
