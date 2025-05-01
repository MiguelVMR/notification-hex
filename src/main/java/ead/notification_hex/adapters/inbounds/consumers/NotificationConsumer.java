package ead.notification_hex.adapters.inbounds.consumers;

import ead.notification_hex.adapters.dtos.NotificationRecordCommandDto;
import ead.notification_hex.core.domain.NotificationDomain;
import ead.notification_hex.core.ports.NotificationServicePort;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * The Class NotificationConsumer
 *
 * @author Miguel Vilela Moraes Ribeiro
 * @since 01/05/2025
 */
@Component
public class NotificationConsumer {

    private final NotificationServicePort notificationServicePort;

    public NotificationConsumer(NotificationServicePort notificationServicePort) {
        this.notificationServicePort = notificationServicePort;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${ead.broker.queue.notificationCommandQueue.name}", durable = "true"),
            exchange = @Exchange(value = "${ead.broker.exchange.notificationCommandExchange}", type = ExchangeTypes.TOPIC, ignoreDeclarationExceptions = "true"),
            key = "${ead.broker.key.notificationCommandKey}")
    )
    public void listen(@Payload NotificationRecordCommandDto notificationRecordCommandDto) {
        var notificationDomain = new NotificationDomain();
        BeanUtils.copyProperties(notificationRecordCommandDto, notificationDomain);
        notificationServicePort.saveNotification(notificationDomain);
    }
}
