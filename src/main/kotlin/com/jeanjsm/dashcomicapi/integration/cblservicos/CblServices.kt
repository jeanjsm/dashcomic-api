package com.jeanjsm.dashcomicapi.integration.cblservicos

import com.google.gson.Gson
import com.jeanjsm.dashcomicapi.integration.vo.CblResponse
import java.util.Collections
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@Service
class CblServices(restTemplateBuilder: RestTemplateBuilder) {

    private val restTemplate: RestTemplate

    private val baseUrl = "https://isbn-search-br.search.windows.net/indexes/isbn-index/docs"

    companion object {
        private const val CBL_API_KEY = "100216A23C5AEE390338BBD19EA86D29"
        private const val CBL_API_VERSION = "2016-09-01"
        private const val CBL_SITE_URL = "https://www.cblservicos.org.br"
    }

    init {
        restTemplate = restTemplateBuilder.build()
    }

    fun search(isbn: String): CblResponse? {

        val url = "$baseUrl/search?api-version=$CBL_API_VERSION"

        val request = CblSearchRequest(
            search = isbn ?: "9786555128529",
            count = true,
            skip = 0,
            top = 12,
            searchFields = "FormattedKey,RowKey"
        )

        val requestHeaders: HttpEntity<CblSearchRequest> = HttpEntity(request, buildHeaders())


        val response = restTemplate.exchange(url, HttpMethod.POST, requestHeaders, String::class.java)
        return Gson().fromJson(response.body, CblResponse::class.java)
    }

    fun buildHeaders(): HttpHeaders {

        val headers = HttpHeaders()
        headers.accept = Collections.singletonList(MediaType.APPLICATION_JSON)
        headers.set("Api-Key", CBL_API_KEY)
        headers.origin = CBL_SITE_URL
        headers.set("Referer", "$CBL_SITE_URL/")

        return headers
    }

//    fun getPostWithCustomHeaders(): Post? {
//        val url = "https://jsonplaceholder.typicode.com/posts/{id}"
//
//        // create headers
//        val headers = HttpHeaders()
//        // set `accept` header
//        headers.accept = Collections.singletonList(MediaType.APPLICATION_JSON)
//        // set custom header
//        headers.set("x-request-source", "desktop")
//
//        // build the request
//        val request: HttpEntity<*> = HttpEntity<Any?>(headers)
//
//        // use `exchange` method for HTTP call
//        val response: ResponseEntity<Post> = restTemplate.exchange(url, HttpMethod.GET, request, Post::class.java, 1)
//        return if (response.getStatusCode() == HttpStatus.OK) {
//            response.getBody()
//        } else {
//            null
//        }
//    }
}
