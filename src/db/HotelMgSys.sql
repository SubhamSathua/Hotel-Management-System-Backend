create database HotelManagementSystem;
use HotelManagementSystem;

INSERT INTO users (email, password, role, status, created_at, updated_at)
VALUES
('admin@gmail.com', 'admin123', 'ADMIN', 'ACTIVE', NOW(), NOW()),
('manager@gmail.com', 'manager123', 'MANAGER', 'ACTIVE', NOW(), NOW()),
('reception@gmail.com', 'recep123', 'RECEPTION', 'ACTIVE', NOW(), NOW()),
('customer@gmail.com', 'cust123', 'CUSTOMER', 'ACTIVE', NOW(), NOW());



show tables;
select * from users;
describe table users;

-- Drop
drop table users;

