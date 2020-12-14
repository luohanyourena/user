package com.letter.user.service;

import com.letter.user.dataobject.UserInfo;
import org.springframework.stereotype.Service;

/**
 * create:luohan
 */
public interface UserInfoService {
    UserInfo findByOpenid(String openid);
}
