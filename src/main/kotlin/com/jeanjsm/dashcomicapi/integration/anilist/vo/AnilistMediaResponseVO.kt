package com.jeanjsm.dashcomicapi.integration.anilist.vo

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class AnilistMediaResponseVO(
    @JsonProperty(value = "data") val data: Data
)

data class Data(
    @JsonProperty(value = "Page") val page: Page
)

data class Page(
    @JsonProperty(value = "pageInfo") val pageInfo: PageInfo,
    @JsonProperty(value = "media") val media: List<Media>
)

data class PageInfo(
    @JsonProperty(value = "total") val total: Int,
    @JsonProperty(value = "perPage") val perPage: Int,
    @JsonProperty(value = "currentPage") val currentPage: Int,
    @JsonProperty(value = "lastPage") val lastPage: Int,
    @JsonProperty(value = "hasNextPage") val hasNextPage: Boolean,
)

data class Media(
    @JsonProperty(value = "id") val id: Int,
    @JsonProperty(value = "idMal") val idMal: Int,
    @JsonProperty(value = "description") val description: String,
    @JsonProperty(value = "status") val status: String,
    @JsonProperty(value = "title") val title: Title,
    @JsonProperty(value = "type") val type: String,
    @JsonProperty(value = "genres") val genres: List<String>,
    @JsonProperty(value = "coverImage") val coverImage: CoverImage
)

data class Title(
    @JsonProperty(value = "english") val english: String? = null,
    @JsonProperty(value = "romaji") val romaji: String? = null
)

data class CoverImage(
    @JsonProperty(value = "extraLarge") val extraLarge: String,
    @JsonProperty(value = "medium") val medium: String,
    @JsonProperty(value = "large") val large: String
)

