package com.example.demo.validator

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.http.HttpStatus
import java.time.LocalDateTime

//@Getter
//@Setter
//@AllArgsConstructor
class ApiError (
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    var timestamp: LocalDateTime? = null,
    var status: HttpStatus? = null,
    var message: String? = null,
    var errors: List<String>? = null
)
