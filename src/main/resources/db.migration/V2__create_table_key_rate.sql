CREATE TABLE key_rate
(
    id          BIGINT NOT NULL PRIMARY KEY,
    date        TIMESTAMP WITH TIME ZONE,
    rate        NUMERIC(4, 2)
)