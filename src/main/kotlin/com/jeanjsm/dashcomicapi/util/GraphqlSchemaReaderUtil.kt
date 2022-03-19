package com.jeanjsm.dashcomicapi.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component

@Component
class GraphqlSchemaReaderUtil {

    @Autowired
    private lateinit var resourceLoader: ResourceLoader

    fun getSchemaFromFileName(fileName: String): String {
        return resourceLoader.getResource("classpath:graphql/$fileName.graphql").file.readText()
    }

}
