-- Create Database
-- CREATE DATABASE IF NOT EXISTS jsp;
-- USE jsp;

-- Category Table
CREATE TABLE IF NOT EXISTS category (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Supplier Table
CREATE TABLE IF NOT EXISTS supplier (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cell VARCHAR(50),
    contactPersonName VARCHAR(255),
    contactPersonCell VARCHAR(50),
    address TEXT
);

-- Product Table
CREATE TABLE IF NOT EXISTS product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL DEFAULT 0.0,
    quantity DOUBLE NOT NULL DEFAULT 0.0,
    supplierId INT,
    categoryId INT,
    FOREIGN KEY (supplierId) REFERENCES supplier(id) ON DELETE SET NULL,
    FOREIGN KEY (categoryId) REFERENCES category(id) ON DELETE SET NULL
);

-- Sales Table
CREATE TABLE IF NOT EXISTS sales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    invoice_no VARCHAR(100) UNIQUE NOT NULL,
    sales_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    customer_cell VARCHAR(50),
    total_amount DOUBLE NOT NULL DEFAULT 0.0
);

-- Sales Item Table
CREATE TABLE IF NOT EXISTS sales_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sales_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity DOUBLE NOT NULL,
    unit_price DOUBLE NOT NULL,
    total_price DOUBLE NOT NULL,
    discount_rate DOUBLE DEFAULT 0.0,
    discount DOUBLE DEFAULT 0.0,
    actual_price DOUBLE NOT NULL,
    FOREIGN KEY (sales_id) REFERENCES sales(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
);

-- User Table
CREATE TABLE IF NOT EXISTS user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userName VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) DEFAULT 'Admin'
);
