-- V2__Add_user_timestamps.sql
-- Add createdAt and updatedAt columns to users table

ALTER TABLE users ADD COLUMN created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE users ADD COLUMN updated_at TIMESTAMP;

-- Ensure isActive is not null
ALTER TABLE users MODIFY COLUMN is_active BOOLEAN NOT NULL DEFAULT true;
