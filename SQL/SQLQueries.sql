CREATE DATABASE ecommerce_testing;
USE ecommerce_testing;
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);
CREATE TABLE products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    price DECIMAL(10,2),
    stock INT
);
CREATE TABLE cart (
    cart_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);
CREATE TABLE orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    total_amount DECIMAL(10,2),
    order_date DATE,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
CREATE TABLE payments (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    payment_method VARCHAR(50),
    payment_status VARCHAR(30),
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);
INSERT INTO users (name, email, password)
VALUES
('John', 'john@gmail.com', '12345'),
('Alice', 'alice@gmail.com', '12345');
INSERT INTO products (product_name, category, price, stock)
VALUES
('Gaming Laptop', 'Electronics', 50000, 5),
('Wireless Mouse', 'Electronics', 1200, 20),
('Mechanical Keyboard', 'Electronics', 3500, 15);
INSERT INTO cart (user_id, product_id, quantity)
VALUES
(1, 1, 1),
(1, 2, 2);
INSERT INTO orders (user_id, total_amount, order_date)
VALUES
(1, 52400, CURDATE());
INSERT INTO payments (order_id, payment_method, payment_status)
VALUES
(1, 'UPI', 'Success');
SELECT * FROM users;
SELECT * FROM products;
SELECT * FROM cart;
SELECT * FROM orders;
SELECT * FROM payments;
SELECT COUNT(*) AS Total_Users
FROM users;
SELECT *
FROM products
WHERE stock > 10;
SELECT *
FROM payments
WHERE payment_status='Success';
SELECT
u.name,
o.order_id,
o.total_amount
FROM users u
JOIN orders o
ON u.user_id=o.user_id;
SELECT
o.order_id,
o.total_amount,
p.payment_method,
p.payment_status
FROM orders o
JOIN payments p
ON o.order_id=p.order_id;
