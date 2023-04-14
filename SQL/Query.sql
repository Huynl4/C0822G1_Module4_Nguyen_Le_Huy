create database fresh_foods;
use fresh_foods; 

create table role (
id int primary key auto_increment,
name varchar(25)
);

create table account(
id int primary key auto_increment,
name varchar(45),
avatar varchar(255),
address varchar(255),
password varchar(225),
email varchar(45),
phone_number varchar(15),
user_name varchar (45)
);

create table account_role (
id int primary key auto_increment,
id_role int,
id_account int,
foreign key (id_role) references `role`(id),
foreign key (id_account) references account(id)
);
CREATE TABLE Category (
  category_id INT PRIMARY KEY,
  category_name VARCHAR(255)
);
CREATE TABLE Supplier (
  supplier_id INT PRIMARY KEY,
  supplier_name VARCHAR(255),
  supplier_address VARCHAR(255),
  supplier_phone VARCHAR(20)
);
CREATE TABLE Product (
  product_id INT PRIMARY KEY,
  product_name VARCHAR(255),
  product_price double,
  product_description TEXT,
  category_id INT,
  supplier_id INT,
  FOREIGN KEY (category_id) REFERENCES Category(category_id),
  FOREIGN KEY (supplier_id) REFERENCES Supplier(supplier_id)
);

CREATE TABLE Oder (
  oder_id INT PRIMARY KEY,
  account_id INT,
  oder_date DATE,
  FOREIGN KEY (account_id) REFERENCES account(id)
);
CREATE TABLE Oder_Detail (
  oder_detail_id INT PRIMARY KEY,
  oder_id INT,
  product_id INT,
  product_quantity INT,
  product_price double,
  FOREIGN KEY (oder_id) REFERENCES Oder(oder_id),
  FOREIGN KEY (product_id) REFERENCES Product(product_id)
);