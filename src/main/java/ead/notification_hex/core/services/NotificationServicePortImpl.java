package ead.notification_hex.core.services;

import ead.notification_hex.core.domain.NotificationDomain;
import ead.notification_hex.core.domain.PageInfo;
import ead.notification_hex.core.domain.enums.NotificationStatus;
import ead.notification_hex.core.ports.NotificationPersistencePort;
import ead.notification_hex.core.ports.NotificationServicePort;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The Class NotificationServicePortImpl
 *
 * @author Miguel Vilela Moraes Ribeiro
 * @since 01/05/2025
 */

public class NotificationServicePortImpl implements NotificationServicePort {

    private final NotificationPersistencePort notificationPersistencePort;

    public NotificationServicePortImpl(NotificationPersistencePort notificationPersistencePort) {
        this.notificationPersistencePort = notificationPersistencePort;
    }

    @Override
    public NotificationDomain saveNotification(NotificationDomain notificationDomain) {
        notificationDomain.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        notificationDomain.setNotificationStatus(NotificationStatus.CREATED);
        return notificationPersistencePort.save(notificationDomain);
    }

    @Override
    public List<NotificationDomain> findAllNotificationsByUser(UUID userId, PageInfo pageInfo) {
        return notificationPersistencePort.findAllByUserIdAndNotificationStatus(userId, NotificationStatus.CREATED, pageInfo);
    }

    @Override
    public Optional<NotificationDomain> findByNotificationIdAndUserId(UUID notificationId, UUID userId) {
        return notificationPersistencePort.findByNotificationIdAndUserId(notificationId, userId);
    }

    @Override
    public NotificationDomain updateNotification(NotificationStatus notificationStatus, NotificationDomain notificationDomain) {
        return notificationPersistencePort.update(notificationStatus, notificationDomain);
    }
}
