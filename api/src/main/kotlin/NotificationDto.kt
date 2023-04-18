import io.swagger.v3.oas.annotations.media.Schema
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

@Schema(name = "Notification", description = "DTO for work with user's notifications")
data class NotificationDto(
    @NotNull
    @Schema(type = "String", description = "chat id's telegram chat")
    val chatId: String,
    @NotNull
    @Schema(type = "String", description = "text notification")
    val text: String,
    @Nullable
    @Schema(type = "String", description = "link notification")
    val link: String?
)
