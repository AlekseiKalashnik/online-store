CREATE TABLE customer
(
    id           SERIAL PRIMARY KEY,
    firstname    VARCHAR(50)  NOT NULL,
    lastname     VARCHAR(50)  NOT NULL,
    "login"      VARCHAR(50)  NOT NULL UNIQUE,
    address      VARCHAR(255) NOT NULL,
    dob          DATE         NOT NULL,
    gender       VARCHAR(50)  NOT NULL,
    email        VARCHAR(100) NOT NULL UNIQUE,
    phone_number BIGINT       NOT NULL UNIQUE,
    "password"   VARCHAR(50)  NOT NULL,
    created_at   DATE DEFAULT now(),
    last_login   DATE
);

CREATE TABLE product
(
    id           SERIAL PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    description  VARCHAR(255),
    price        INTEGER CHECK ( price >= 0 )
);

CREATE TABLE "order"
(
    id          SERIAL PRIMARY KEY,
    customer_id INTEGER REFERENCES customer (id),
    product_id  INTEGER REFERENCES product (id),
    quantity    INTEGER CHECK ( quantity >= 0 ),
    created_at  DATE DEFAULT now()
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
