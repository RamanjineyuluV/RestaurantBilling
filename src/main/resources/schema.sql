CREATE TABLE customer_order ( 
   id BIGINT NOT NULL, 
   name VARCHAR(50), 
   arrangement VARCHAR(20), 
   subtotal DECIMAL(20,2),
   discount DECIMAL(20,2),
   tax DECIMAL(20,2),
   total DECIMAL(20,2), 
PRIMARY KEY(id)
);