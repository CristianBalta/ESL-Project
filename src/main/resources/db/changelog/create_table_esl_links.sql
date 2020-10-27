CREATE TABLE esl_links(
deleted BOOLEAN DEFAULT FALSE,
esl_id SERIAL NOT NULL,
product_id SERIAL NOT NULL,
outlet_id SERIAL NOT NULL,
CONSTRAINT fk_outlet_id FOREIGN KEY (outlet_id) REFERENCES outlets(id),
CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES products(id),
CONSTRAINT fk_esl_id FOREIGN KEY (esl_id) REFERENCES esls(id),
CONSTRAINT pk_compose_products_outlets_esls_id PRIMARY KEY (esl_id, product_id, outlet_id)
);