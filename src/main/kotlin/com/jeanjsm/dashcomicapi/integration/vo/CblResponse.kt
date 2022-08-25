package com.jeanjsm.dashcomicapi.integration.vo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CblResponse(
    @SerializedName("@odata.context")
    val context: String,
    @SerializedName("@odata.count")
    val count: Int,
    @SerializedName("value")
    val value: List<CblValueResponse>
) : Serializable
