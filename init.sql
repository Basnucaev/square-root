CREATE TABLE quadratic_equation_root
(
    id            SERIAL           NOT NULL,
    coefficient_a DOUBLE PRECISION NOT NULL,
    coefficient_b DOUBLE PRECISION NOT NULL,
    coefficient_c DOUBLE PRECISION NOT NULL,
    root_one      DOUBLE PRECISION NOT NULL,
    root_two      DOUBLE PRECISION DEFAULT NULL,
    UNIQUE (coefficient_a, coefficient_b, coefficient_c),
    CONSTRAINT quadratic_equation_root_pk
        PRIMARY KEY (id)
);