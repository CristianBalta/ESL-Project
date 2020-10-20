CREATE TABLE products_outlets(
price SERIAL,
deleted BOOLEAN DEFAULT FALSE,
product_entity_id SERIAL NOT NULL,
outlet_entity_id SERIAL NOT NULL,
CONSTRAINT fk_outlet_id FOREIGN KEY (outlet_entity_id) REFERENCES outlets(id),
CONSTRAINT fk_product_id FOREIGN KEY (product_entity_id) REFERENCES products(id),
CONSTRAINT pk_compose_products_outlets_id PRIMARY KEY (product_entity_id, outlet_entity_id)
);