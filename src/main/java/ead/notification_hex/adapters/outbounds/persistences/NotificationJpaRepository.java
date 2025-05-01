package ead.notification_hex.adapters.outbounds.persistences;

import ead.notification_hex.adapters.outbounds.entities.NotificationEntity;
import ead.notification_hex.core.domain.enums.NotificationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * The Interface NotificationJpaRepository
 *
 * @author Miguel Vilela Moraes Ribeiro
 * @since 01/05/2025
 */
@Repository
public interface NotificationJpaRepository extends JpaRepository<NotificationEntity,UUID> {

    Page<NotificationEntity> findAllByUserIdAndNotificationStatus(UUID userId, NotificationStatus notificationStatus, Pageable pageable);

    Optional<NotificationEntity> findByNotificationIdAndUserId(UUID notificationId, UUID userId);
}
