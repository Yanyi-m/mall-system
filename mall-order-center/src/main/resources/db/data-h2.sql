DELETE FROM mall_order;

INSERT INTO mall_order (id, order_no, user_id, product_id, total_amount, create_time, update_time, order_status) VALUES
(1, '1000_202006190927240001', 1, 1, 100, '2020-06-18 10:42', '2020-06-18 10:42',1),
(2, '1000_202006190927240002', 1, 2, 200, '2020-06-18 10:42', '2020-06-18 10:42',2),
(3, '1000_202006190927240003', 1, 1, 100, '2020-06-18 10:42', '2020-06-18 10:42',3),
(4, '1000_202006190927240004', 2, 2, 200, '2020-06-18 10:42', '2020-06-18 10:42',4),
(5, '1000_202006190927240005', 2, 1, 100, '2020-06-18 10:42', '2020-06-18 10:42',5);