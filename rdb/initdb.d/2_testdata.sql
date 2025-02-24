## 2. テストデータ (2_testdata.sql)

USE concert_ticket_db;

-- ユーザーテストデータ
INSERT INTO users (user_id, email, password_hash, first_name, last_name, phone_number) VALUES
('u-001', 'yamada@example.com', 'hash_password_1', '太郎', '山田', '090-1234-5678'),
('u-002', 'tanaka@example.com', 'hash_password_2', '花子', '田中', '090-8765-4321'),
('u-003', 'suzuki@example.com', 'hash_password_3', '一郎', '鈴木', '090-9999-8888');

-- チケット予約テストデータ
INSERT INTO ticket_reservations (reservation_id, user_id, concert_id, seat_id, price, status) VALUES
('r-001', 'u-001', 'c-001', 'A-1', 12000.00, 'CONFIRMED'),
('r-002', 'u-002', 'c-001', 'A-2', 12000.00, 'CONFIRMED'),
('r-003', 'u-003', 'c-002', 'B-1', 8000.00, 'PENDING');

-- 支払い情報テストデータ
INSERT INTO payments (payment_id, reservation_id, amount, payment_method, status) VALUES
('p-001', 'r-001', 12000.00, 'CREDIT_CARD', 'COMPLETED'),
('p-002', 'r-002', 12000.00, 'BANK_TRANSFER', 'COMPLETED'),
('p-003', 'r-003', 8000.00, 'CREDIT_CARD', 'PENDING');

-- キャンセル履歴テストデータ
INSERT INTO cancellation_history (cancellation_id, reservation_id, reason, refund_amount) VALUES
('c-001', 'r-001', '予定が合わなくなったため', 10800.00);