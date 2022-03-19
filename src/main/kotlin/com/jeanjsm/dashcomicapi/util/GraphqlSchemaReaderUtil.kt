package com.jeanjsm.dashcomicapi.util

import java.io.BufferedReader
import java.io.InputStreamReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component

@Component
class GraphqlSchemaReaderUtil {

    @Autowired
    private lateinit var resourceLoader: ResourceLoader

    fun getSchemaFromFileName(fileName: String): String {
        val resource = javaClass.getResourceAsStream("/graphql/$fileName.graphql")
        val reader = BufferedReader(InputStreamReader(resource))
        return reader.readText()
    }

}
