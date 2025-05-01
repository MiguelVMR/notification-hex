package ead.notification_hex.adapters.dtos;

import java.util.UUID;

/**
 * The Record NotificationRecordCommandDto
 *
 * @author Miguel Vilela Moraes Ribeiro
 * @since 01/05/2025
 */
public record NotificationRecordCommandDto(String title,
                                           String message,
                                           UUID userId) {
}
