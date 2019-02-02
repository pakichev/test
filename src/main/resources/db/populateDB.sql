DELETE
FROM orders;
DELETE
FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password, role)
VALUES ('User', 'user@yandex.ru', 'user', 'ROLE_USER'),
       ('Admin', 'admin@gmail.com', 'admin', 'ROLE_ADMIN'),
       ('Operator', 'operator@gmail.com', 'operator', 'ROLE_OPERATOR');

INSERT INTO orders (num, date_time)
VALUES ('101001', '2019-02-02 10:00:00'),
       ('101002', '2019-02-02 13:00:00'),
       ('101003', '2019-02-02 20:00:00'),
       ('101004', '2019-02-02 10:00:00'),
       ('101005', '2019-02-02 13:00:00'),
       ('101006', '2019-02-02 20:00:00'),
       ('101007', '2019-02-02 14:00:00'),
       ('101008', '2019-02-02 21:00:00');

