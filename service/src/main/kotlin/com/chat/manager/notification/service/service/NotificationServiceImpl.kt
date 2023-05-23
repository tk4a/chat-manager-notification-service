package com.chat.manager.notification.service.service

import NotificationDto
import com.chat.manager.notification.service.entity.Notification
import com.chat.manager.notification.service.mapper.toDto
import com.chat.manager.notification.service.repository.NotificationRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class NotificationServiceImpl(val repository: NotificationRepository) : NotificationService {
    override fun save(notification: Notification): Mono<Void> = repository.save(notification).then()
    override fun getAllByChatId(id: String): Flux<NotificationDto> = repository.getAllByChatId(id).map { it.toDto() }
}