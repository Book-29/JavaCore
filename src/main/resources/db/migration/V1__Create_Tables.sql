
CREATE TABLE IF NOT EXISTS patients (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    phone_number VARCHAR(255),
    is_deleted BOOLEAN DEFAULT FALSE,
    birth_date DATE
);

INSERT INTO patients (id, name, address, phone_number, birth_date) values(1, 'Иванов Иван Иванович', '123 Main St', '555-555-5555', '1990-01-01');
INSERT INTO patients (id, name, address, phone_number, birth_date) values(2, 'Петров Петр Петрович', '456 Main St', '555-555-5555', '1990-01-01');

CREATE TABLE IF NOT EXISTS doctor (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(255),
specialization VARCHAR(255)
);

INSERT INTO doctor (id, name, specialization) values(1, 'Иванов Петр Иванович', 'Педиатр');
INSERT INTO doctor (id, name, specialization) values(2, 'Петров Иван Петрович', 'Офтальмолог');

CREATE TABLE IF NOT EXISTS diagnosis (
id BIGSERIAL PRIMARY KEY,
code VARCHAR(255),
description VARCHAR(255),
is_deleted BOOLEAN DEFAULT FALSE
);



INSERT INTO diagnosis (id, code, description) values(1, '123', 'Диагноз 1');
INSERT INTO diagnosis (id, code, description) values(2, '456', 'Диагноз 2');

CREATE TABLE IF NOT EXISTS appointments (
id BIGSERIAL PRIMARY KEY,
patient_id BIGINT REFERENCES patients(id),
doctor_id BIGINT REFERENCES doctor(id),
diagnosis_id BIGINT REFERENCES diagnosis(id)
);


INSERT INTO appointments (id, patient_id, doctor_id, diagnosis_id) values(1, 1, 1, 1);
INSERT INTO appointments (id, patient_id, doctor_id, diagnosis_id) values(2, 2, 2, 2);
INSERT INTO appointments (id, patient_id, doctor_id, diagnosis_id) values(3, 1, 2, 2);