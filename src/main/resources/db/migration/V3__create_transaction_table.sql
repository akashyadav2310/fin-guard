CREATE TABLE transaction (
    transaction_id VARCHAR(255) PRIMARY KEY,
    customer_id VARCHAR(255),
    merchant_id VARCHAR(255),
    amount NUMERIC(19, 2),
    currency VARCHAR(255),
    channel VARCHAR(255),
    device_id VARCHAR(255),
    location VARCHAR(255),
    status VARCHAR(255),
    created_at TIMESTAMP
);