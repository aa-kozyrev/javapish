# Инструкция по развертыванию приложения

## Структура файлов

В каталоге с jar-файлом `jdbc-crud-app-v1.0-SNAPSHOT.jar`:

1. Разместите файл `application.properties`
2. Разместите файлы миграций по пути `db/migration/`

Должна получиться следующая структура:

- rootdir/
    - jdbc-crud-app-v1.0-SNAPSHOT.jar
    - application.properties
    - db/
        - migration/
            - V1__Create_table_product.sql
            - V2__Create_table_customer.sql
            - V3__Create_table_order_status.sql
            - V4__Create_table_order.sql
            - V5__Add_test_data_product.sql
            - V6__Add_test_data_customer.sql
            - V7__Add_test_data_order_status.sql
            - V8__Add_test_data_order.sql

## Запуск приложения

3. Запустите jar-файл в командной строке:

```bash
java -jar jdbc-crud-app-v1.0-SNAPSHOT.jar