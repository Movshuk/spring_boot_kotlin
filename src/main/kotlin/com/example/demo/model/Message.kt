package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class Message(

    @JsonProperty("messageData")
    @field:Valid
    @field:NotNull(message = "messageData NOT NULL!!!")
    val messageData: MessageData?
)

data class MessageData(
    @JsonProperty("status")
    @field:NotBlank(message = "status NOT BLANK!!!")
    val status: String? = null
)



