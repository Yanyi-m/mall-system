# mall-system
简单商城系统

### 框架使用
``` 
Spring-cloud（consul+feign）、Mybatis-plus
``` 

### 数据库使用
``` 
H2
数据源/db/data-h2.sql
表结构/db/schema-h2.sql
``` 

### 系统结构
``` 
mall-parent 管理jar包
mall-common 公共类
mall-order-center 订单中心
mall-inventory-center 库存中心
``` 

### api入口
``` 
获取订单 localhost:7001/queryOrders
生成订单 localhost:7001/createOrders
``` 

### 单元测试
``` 
获取订单测试 com.yym.mall.ordercenter.OrderCenterApplicationTests::queryOrders
创建订单测试 com.yym.mall.ordercenter.OrderCenterApplicationTests::createOrders
``` 
