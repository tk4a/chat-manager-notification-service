package com.chat.manager.notification.service.mapper

import NotificationDto
import com.chat.manager.notification.service.entity.Notification

fun NotificationDto.toEntity() =
    Notification(
        notificationId = null,
        chatId = chatId,
        text = text,
        link = link
    )

fun Notification.toDto() =
    NotificationDto(
        chatId,
        text,
        link
    )