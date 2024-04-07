package ru.orobtsovv.userservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ru.orobtsovv.userservice.utils.constants.MQConstants.PROFILE_CREATE;
import static ru.orobtsovv.userservice.utils.constants.MQConstants.TELEGRAM_REMOVE;
import static ru.orobtsovv.userservice.utils.constants.MQConstants.TELEGRAM_SAVE;

@Configuration
public class AmqpConfig {
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue profileCreate() {
        return new Queue(PROFILE_CREATE, true);
    }

    @Bean
    public Queue tgAdd() {
        return new Queue(TELEGRAM_SAVE, true);
    }

    @Bean
    public Queue tgDelete() {
        return new Queue(TELEGRAM_REMOVE, true);
    }
}
