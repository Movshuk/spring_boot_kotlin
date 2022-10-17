package com.example.demo.validator

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime
import java.util.ArrayList
import java.util.stream.Collectors

// : ResponseEntityExceptionHandler()
@ControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler
    fun handleIllegalStateException(ex: IllegalStateException): ResponseEntity<ErrorMessageModel> {

        val errorMessage = ErrorMessageModel(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException):
            ResponseEntity<ApiError> {

        var details: List<String> = ArrayList()

        details = ex.bindingResult
            .fieldErrors
            .stream()
            .map { error: FieldError -> error.objectName + " : " + error.defaultMessage }
            .collect(Collectors.toList())

        val err = ApiError(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST,
            "Validation Errors",
            details
        )
        return ResponseEntity(err, HttpStatus.BAD_REQUEST)
    }
}