package com.chat.manager.notification.service

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
@EnableEurekaClient
@EnableWebFlux
@OpenAPIDefinition(info = Info(
    title = "Notification service",
    description = "Service for work with notification from Telegram's chats",
    contact = Contact(name = "Artem", email = "arteemtkacheev@gmail.com")
))
class ChatManagerNotificationServiceApp

fun main() {
    runApplication<ChatManagerNotificationServiceApp>()
}