package com.jeanjsm.dashcomicapi.controller

import com.jeanjsm.dashcomicapi.integration.cblservicos.CblServices
import com.jeanjsm.dashcomicapi.integration.vo.CblResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cbl")
class CblTestController(
    val cblServices: CblServices
) {

    @GetMapping("/search/{isbn}")
    fun test(@PathVariable isbn: String) : CblResponse? {
        return cblServices.search(isbn)
    }

}
