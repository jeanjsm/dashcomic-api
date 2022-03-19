package com.jeanjsm.dashcomicapi.integration.anilist.vo

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class GraphqlRequestBody(
    var query: String? = null,
    var variables: VariablesVO? = null
)

