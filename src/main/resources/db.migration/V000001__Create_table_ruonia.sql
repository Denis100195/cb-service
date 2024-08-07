CREATE TABLE ruonia
(
    id          BIGSERIAL NOT NULL PRIMARY KEY,
    date        TIMESTAMP WITH TIME ZONE,
    ruonia      NUMERIC(6, 4),
    volume      NUMERIC(7, 4),
    date_update TIMESTAMP WITH TIME ZONE
);