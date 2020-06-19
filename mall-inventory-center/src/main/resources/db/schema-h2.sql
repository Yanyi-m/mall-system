DROP TABLE IF EXISTS mall_inventory;

CREATE TABLE mall_inventory
(
	id BIGINT(20) NOT NULL auto_increment COMMENT '主键ID',
    price DECIMAL(11,2) NULL DEFAULT NULL COMMENT '价格',
    create_time DATETIME NULL DEFAULT NULL COMMENT '创建时间',
    update_time DATETIME NULL DEFAULT NULL COMMENT '更新时间',
    stock INT(11) NULL DEFAULT NULL COMMENT '库存',
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS mall_inventory_records;

CREATE TABLE mall_inventory_records
(
	id BIGINT(20) NOT NULL auto_increment COMMENT '主键ID',
    product_id BIGINT(20) NULL DEFAULT NULL COMMENT '产品id',
    create_time DATETIME NULL DEFAULT NULL COMMENT '创建时间',
    update_time DATETIME NULL DEFAULT NULL COMMENT '更新时间',
    order_no VARCHAR(30) NULL DEFAULT NULL COMMENT '订单号',
    option_type INT(11) NULL DEFAULT NULL COMMENT '操作类型 1 - 扣减，2 - 回滚',
	PRIMARY KEY (id)
);