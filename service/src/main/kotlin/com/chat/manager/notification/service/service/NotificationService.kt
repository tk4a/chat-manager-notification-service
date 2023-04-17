package com.chat.manager.notification.service.service

import NotificationDto
import com.chat.manager.notification.service.entity.Notification
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface NotificationService {
    fun save(notification: Notification): Mono<Notification>
    fun getAllByChatId(id: String): Flux<NotificationDto>
}