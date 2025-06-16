CREATE TABLE IF NOT EXISTS to_do (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    due_date DATE,
    completed BOOLEAN
);
