### Environment variables

#### Опциональные параметры:

SPRING_PROFILE - опционально; основные значения: with-mocks, development;

- with-mocks - все сервисы заменяются на заглушки (по умолчанию)
- development - без заглушек

#### Обязательные параметры:

RABBITMQ_HOST, RABBITMQ_PORT - хост и порт rabbitmq; по умолчанию localhost и 5672

DB_HOST, DB_PORT, DB_NAME, DB_USER, DB_PASSWORD