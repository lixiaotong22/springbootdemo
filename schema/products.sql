DROP DATABASE IF EXISTS springbootdemo_system;
CREATE DATABASE springbootdemo_system DEFAULT CHARACTER SET utf8;
USE springbootdemo_system;

##创建paper表
CREATE TABLE products (
   id   INT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(30),
   price  INT(23)
)ENGINE=InnoDB; 

##插入初始化数据
INSERT INTO products (name,price) 
             VALUES('name 001',200);
INSERT INTO products (name,price)
             VALUES('name 002',400);
INSERT INTO products (name,price)
             VALUES('name 003',600);

COMMIT;