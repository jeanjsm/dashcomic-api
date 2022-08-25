package com.jeanjsm.dashcomicapi.integration.vo

import com.google.gson.annotations.SerializedName

data class CblValueResponse(
    @SerializedName("RowKey")
    val rowKey: String,
    @SerializedName("Authors")
    val authors: List<String>,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Edicao")
    val edition: String,
    @SerializedName("Imprint")
    val imprint: String,
    @SerializedName("Sinopse")
    val synopsis: String,
    @SerializedName("Ano")
    val year: String
)
