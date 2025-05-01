package ead.notification_hex.core.ports;

import ead.notification_hex.core.domain.NotificationDomain;
import ead.notification_hex.core.domain.PageInfo;
import ead.notification_hex.core.domain.enums.NotificationStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The Interface NotificationServicePort
 *
 * @author Miguel Vilela Moraes Ribeiro
 * @since 01/05/2025
 */
public interface NotificationServicePort {
    NotificationDomain saveNotification(NotificationDomain notificationDomain);
    List<NotificationDomain> findAllNotificationsByUser(UUID userId, PageInfo pageInfo);
    Optional<NotificationDomain> findByNotificationIdAndUserId(UUID notificationId, UUID userId);
    NotificationDomain updateNotification(NotificationStatus notificationStatus, NotificationDomain notificationDomain);
}

