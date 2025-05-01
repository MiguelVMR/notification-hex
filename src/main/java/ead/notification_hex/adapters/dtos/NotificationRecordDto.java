package ead.notification_hex.adapters.dtos;

import ead.notification_hex.core.domain.enums.NotificationStatus;
import jakarta.validation.constraints.NotNull;

/**
 * The Record NotificationRecordDto
 *
 * @author Miguel Vilela Moraes Ribeiro
 * @since 01/05/2025
 */
public record NotificationRecordDto(@NotNull NotificationStatus notificationStatus) {
}
