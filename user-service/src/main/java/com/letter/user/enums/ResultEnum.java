package com.letter.user.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    LOGIN_EORR(1,"用户不存在"),
    ROLE_EORR(1,"用户身份错误");
//    JOSN_EORR(2,"JSON转换失败");
//    CLOSE(2,"取消");

    private Integer code;
    private String message;

    ResultEnum (Integer code,String message){
        this.code=code;
        this.message=message;
    }
}
