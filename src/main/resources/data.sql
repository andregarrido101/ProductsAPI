CREATE TABLE products (
    id varchar(255) NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL,
    description varchar(300),
    price decimal(10, 2) NOT NULL
);