package com.chat.manager.notification.service.controller

import NotificationDto
import com.chat.manager.notification.service.mapper.toEntity
import com.chat.manager.notification.service.service.NotificationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.parameters.RequestBody as SwaggerRequestBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/notification")
@Tag(name = "Notification controller", description = "Controller for work with notification (CRUD)")
class NotificationController(
    val notificationService: NotificationService
) {
    @Operation(
        operationId = "create",
        method = "POST",
        responses = [ApiResponse(
            description = "successful operation",
            responseCode = "200",
            content = [
                Content(
                    schema = Schema(implementation = NotificationDto::class),
                    mediaType = "application/json"
                )
            ]
        )],
        requestBody = SwaggerRequestBody(content = [Content(schema = Schema(implementation = NotificationDto::class))])
    )
    @PostMapping
    suspend fun create(@RequestBody request: NotificationDto): Mono<Void> = notificationService.save(request.toEntity())

    @Operation(
        operationId = "getAllByChatId",
        method = "GET",
        responses = [ApiResponse(
            responseCode = "200",
            description = "successful operation",
            content = [Content(schema = Schema(implementation = NotificationDto::class, title = "List of notifications (Flux)"))]
        )],
        requestBody = SwaggerRequestBody(content = [Content(schema = Schema(implementation = NotificationDto::class))])
    )
    @GetMapping("/{id}")
    suspend fun getAllByChatId(@PathVariable id: String): Flux<NotificationDto> = notificationService.getAllByChatId(id);
}