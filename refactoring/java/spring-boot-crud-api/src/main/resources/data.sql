-- Create the employee table if it doesn't exist
CREATE TABLE IF NOT EXISTS employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);
INSERT INTO employee (name, surname, email) VALUES ('John', 'Doe', 'john.doe@example.com');
INSERT INTO employee (name, surname, email) VALUES ('Jane', 'Doe', 'jane.doe@example.com');