CREATE TABLE products_outlets(
product_id SERIAL NOT NULL,
outlet_id SERIAL NOT NULL,
price SERIAL,
deleted BOOLEAN DEFAULT FALSE,

CONSTRAINT fk_outlet_id FOREIGN KEY (outlet_id) REFERENCES outlets(id),
CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES products(id),
CONSTRAINT pk_link_id PRIMARY KEY (product_id, outlet_id)
);