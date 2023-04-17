package com.chat.manager.notification.service.entity

import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table
data class Notification(
    @Id
    val notificationId: String?,
    @NotNull
    val chatId: String = "",
    @NotNull
    @Column("notification_text")
    val text: String = "",
    @Nullable
    val link: String?
)