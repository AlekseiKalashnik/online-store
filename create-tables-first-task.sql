CREATE TABLE customer
(
    id           SERIAL PRIMARY KEY,
    firstname    VARCHAR(50)  NOT NULL,
    lastname     VARCHAR(50)  NOT NULL,
    "login"      VARCHAR(50)  NOT NULL UNIQUE,
    dob          DATE         NOT NULL,
    gender       VARCHAR(50)  NOT NULL,
    email        VARCHAR(100) NOT NULL UNIQUE,
    phone_number BIGINT       NOT NULL UNIQUE,
    "password"   VARCHAR(50)  NOT NULL,
    created_at   TIMESTAMP DEFAULT now(),
    modified_at  TIMESTAMP
);

CREATE TABLE customer_address
(
    id          SERIAL PRIMARY KEY,
    customer_id INTEGER REFERENCES customer (id),
    city        VARCHAR(100) NOT NULL,
    postal_code VARCHAR(100) NOT NULL,
    country     VARCHAR(100) NOT NULL,
    street      VARCHAR(100) NOT NULL,
    house       VARCHAR(100) NOT NULL
);

CREATE TABLE customer_payment
(
    id             SERIAL PRIMARY KEY,
    customer_id    INTEGER REFERENCES customer (id),
    payment_type   VARCHAR(100) NOT NULL,
    "provider"     VARCHAR(100) NOT NULL,
    account_number INTEGER,
    expiry         DATE
);

CREATE TABLE product
(
    id           SERIAL PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    description  VARCHAR(255),
    price        INTEGER CHECK ( price >= 0 ),
    created_at   TIMESTAMP DEFAULT now(),
    modified_at  TIMESTAMP,
    deleted_at   TIMESTAMP
);

CREATE TABLE "order"
(
    id          SERIAL PRIMARY KEY,
    customer_id INTEGER REFERENCES customer (id),
    product_id  INTEGER REFERENCES product (id),
    quantity    INTEGER CHECK ( quantity >= 0 ),
    created_at  TIMESTAMP DEFAULT now(),
    modified_at TIMESTAMP
);

CREATE TABLE "category"
(
    id            SERIAL PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL
);

CREATE TABLE "subcategory"
(
    id               SERIAL PRIMARY KEY,
    category_id      INTEGER REFERENCES "category" (id),
    subcategory_name VARCHAR(100) NOT NULL
);

CREATE TABLE product_subcategory
(
    product_id     INTEGER REFERENCES product (id),
    subcategory_id INTEGER REFERENCES subcategory (id)
);
