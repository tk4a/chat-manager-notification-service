package com.chat.manager.notification.service.repository

import com.chat.manager.notification.service.entity.Notification
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface NotificationRepository : ReactiveCrudRepository<Notification, String> {
    fun getAllByChatId(chatId: String): Flux<Notification>
    @Query(
        """
        INSERT INTO notification VALUES ('test', 'notification', 'notification', 'notification');
    """)
    fun insert(notification: Notification): Mono<Notification>
}