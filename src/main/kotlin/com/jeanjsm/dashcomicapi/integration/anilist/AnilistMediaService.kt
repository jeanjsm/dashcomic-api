package com.jeanjsm.dashcomicapi.integration.anilist

import com.jeanjsm.dashcomicapi.integration.anilist.vo.AnilistMediaResponseVO
import com.jeanjsm.dashcomicapi.integration.anilist.vo.GraphqlRequestBody
import com.jeanjsm.dashcomicapi.integration.anilist.vo.VariablesVO
import com.jeanjsm.dashcomicapi.util.GraphqlSchemaReaderUtil
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

const val url = "https://graphql.anilist.co"

@Service
class AnilistMediaService(
    private val graphqlSchemaReaderUtil: GraphqlSchemaReaderUtil
) {

    fun getMedia(animeName: String): AnilistMediaResponseVO? {
        val webClient = WebClient.builder().build()
        val graphqlRequestBody = GraphqlRequestBody()

        val query = graphqlSchemaReaderUtil.getSchemaFromFileName("getMediaAnilist")

        graphqlRequestBody.query = query
        graphqlRequestBody.variables = VariablesVO(
            search = animeName,
            page = 1,
            perPage = 10
        )
        return webClient.post()
            .uri(url)
            .bodyValue(graphqlRequestBody)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(AnilistMediaResponseVO::class.java)
            .block()
    }

}
