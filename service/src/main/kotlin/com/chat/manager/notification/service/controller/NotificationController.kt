package com.chat.manager.notification.service.controller

import NotificationDto
import com.chat.manager.notification.service.mapper.toDto
import com.chat.manager.notification.service.mapper.toEntity
import com.chat.manager.notification.service.service.NotificationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.parameters.RequestBody as SwaggerRequestBody
import org.springdoc.core.annotations.RouterOperation
import org.springdoc.core.annotations.RouterOperations
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/notification")
class NotificationController(
    val notificationService: NotificationService
) {
    @RouterOperations(value = [RouterOperation(
        path = "/notification",
        method = [RequestMethod.POST],
        beanMethod = "create",
        operation = Operation(
            operationId = "create",
            responses = [ApiResponse(
                responseCode = "200",
                description = "successful operation",
                content = [Content(schema = Schema(implementation = NotificationDto::class))]
            )],
            requestBody = SwaggerRequestBody(content = [Content(schema = Schema(implementation = NotificationDto::class))])
        )
    )])
    @PostMapping
    fun create(@RequestBody request: NotificationDto) = notificationService.save(request.toEntity()).map { it.toDto() }

//    @ApiOperation(
//        value = "Endpoint for search all notifications by chat id from telegram",
//        httpMethod = "GET",
//        produces = "application/json"
//    )
    @GetMapping("/{id}")
    fun getAllByChatId(@PathVariable id: String): Flux<NotificationDto> = notificationService.getAllByChatId(id);
}