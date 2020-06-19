package com.yym.mall.ordercenter.enums;

/**
 * 订单类型枚举类
 * @author yanyimin
 * @date 2020-06-17 21:52
 */
public enum OrderStatusEnum {

    /**
     * 订单超时
     */
    EXPIRED(1, "订单超时"),

    /**
     * 取消
     */
    CANCEL(2,"取消"),

    /**
     * 待支付
     */
    PAY_PENDING(3,"待支付"),

    /**
     * 已支付
     */
    PAYED(4,"已支付"),

    /**
     * 退款中
     */
    REFUNDING(5, "退款中"),

    /**
     * 退款
     */
    REFUND(6, "退款");


    private int index;
    private String name;

    OrderStatusEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }
    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public static Integer getIndex(String name) {
        for(OrderStatusEnum monitorModuleEnum:OrderStatusEnum.values()){
            if(monitorModuleEnum.getName().equals(name)){
                return monitorModuleEnum.getIndex();
            }
        }
        return null;
    }
}
