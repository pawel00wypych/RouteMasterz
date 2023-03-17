#!/bin/bash

echo "spring.jpa.hibernate.ddl-auto=update" > application.properties
echo "spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect" >> application.properties
echo "spring.datasource.url=jdbc:postgresql://$DB_HOST:$DB_PORT/$DB_NAME" >> application.properties

echo "spring.datasource.username=$POSTGRES_USER" >> application.properties
echo "spring.datasource.password=$POSTGRES_PASSWORD" >> application.properties

echo "spring.datasource.driver-class-name=org.postgresql.Driver" >> application.properties

echo "Waiting for the PostgreSQL server to start on $DB_HOST:$DB_PORT"

while ! nc -z "$DB_HOST" "$DB_PORT"; do
  sleep 0.2
done

echo "PostgreSQL Server has started"

#FLYWAY
echo "spring.flyway.url=jdbc:postgresql://$DB_HOST:$DB_PORT/$DB_NAME" >> application.properties
echo "spring.flyway.schemas=routemasterz" >> application.properties
echo "spring.flyway.user=user" >> application.properties
echo "spring.flyway.password=password" >> application.properties
echo "spring.flyway.baseline-on-migrate=false" >> application.properties
echo "spring.flyway.locations=classpath:db/migration" >> application.properties


java -jar app.jar