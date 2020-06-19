package com.yym.mall.inventorycenter.enums;

/**
 * 库存操作枚举类
 * @author yanyimin
 * @date 2020-06-17 21:52
 */
public enum OptionTypeEnum {

    /**
     * 扣减
     */
    DEDUCT(1, "扣减"),

    /**
     * 回滚
     */
    ROLLBACK(2,"回滚");


    private int index;
    private String name;

    OptionTypeEnum(int index, String name) {
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
        for(OptionTypeEnum monitorModuleEnum:OptionTypeEnum.values()){
            if(monitorModuleEnum.getName().equals(name)){
                return monitorModuleEnum.getIndex();
            }
        }
        return null;
    }
}
