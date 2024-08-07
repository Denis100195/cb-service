CREATE TABLE curs_on_date
(
    id          BIGSERIAL NOT NULL PRIMARY KEY,
    date        DATE,
    name        VARCHAR(40),
    nom         DECIMAL,
    curs        NUMERIC(7, 4),
    code        INTEGER,
    ch_code     VARCHAR(3),
    unit_rate   NUMERIC(7, 4)
);