package com.letter.user.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    BUYER(1,"买家"),
    SELLER(2,"卖家");
//    JOSN_EORR(2,"JSON转换失败");
//    CLOSE(2,"取消");

    private Integer code;
    private String message;

    RoleEnum(Integer code, String message){
        this.code=code;
        this.message=message;
    }
}
