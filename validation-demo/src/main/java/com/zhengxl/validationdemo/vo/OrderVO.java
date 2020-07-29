package com.zhengxl.validationdemo.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description:
 * @projectName:validation-demo
 * @see:com.zhengxl.validationdemo.vo
 * @author:郑晓龙
 * @createTime:2020/7/29 12:43
 * @version:1.0
 */
public class OrderVO {
    @NotNull(message = "id 不能为空")
    private Long id;
    @NotBlank(message = "itemName 不能为空")
    private String itemName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
