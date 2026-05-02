CREATE TABLE emails (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    email_from VARCHAR(255),
    email_to VARCHAR(255),
    email_subject VARCHAR(255),
    body TEXT,
    sent_at TIMESTAMP,
    status_email VARCHAR(50)
);