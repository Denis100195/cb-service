CREATE TABLE key_rate
(
    id          BIGSERIAL NOT NULL PRIMARY KEY,
    date        TIMESTAMP WITH TIME ZONE,
    rate        NUMERIC(4, 2)
);