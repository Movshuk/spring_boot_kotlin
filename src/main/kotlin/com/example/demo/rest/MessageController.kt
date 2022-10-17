package com.example.demo.rest

import com.example.demo.model.Message
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class MessageController {

    @RequestMapping(
        value = ["/message"]
    )
    fun post (@Valid @RequestBody request: Message) : ResponseEntity<Any>{
        return ResponseEntity.ok("ok")
    }



}