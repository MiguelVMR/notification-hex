package ead.notification_hex.core.ports;

import ead.notification_hex.core.domain.NotificationDomain;
import ead.notification_hex.core.domain.PageInfo;
import ead.notification_hex.core.domain.enums.NotificationStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The Interface NotificationPersistencePort
 *
 * @author Miguel Vilela Moraes Ribeiro
 * @since 01/05/2025
 */
public interface NotificationPersistencePort {
    NotificationDomain save(NotificationDomain notificationDomain);
    List<NotificationDomain> findAllByUserIdAndNotificationStatus(UUID userId, NotificationStatus notificationStatus, PageInfo pageInfo);
    Optional<NotificationDomain> findByNotificationIdAndUserId(UUID notificationId, UUID userId);
    NotificationDomain update(NotificationStatus notificationStatus, NotificationDomain notificationDomain);
}
