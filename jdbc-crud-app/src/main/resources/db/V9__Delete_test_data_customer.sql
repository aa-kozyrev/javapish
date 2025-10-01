-- дополнительный файл миграции, для тестов
DELETE FROM pish."order" WHERE customer_id = 15;
DELETE FROM pish.customer WHERE phone = '79020000000';

COMMIT;
