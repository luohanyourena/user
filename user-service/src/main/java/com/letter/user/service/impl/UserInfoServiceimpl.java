package com.letter.user.service.impl;

import com.letter.user.dataobject.UserInfo;
import com.letter.user.repositroy.UserInfoRepositroy;
import com.letter.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create:luohan
 */
@Service
public class UserInfoServiceimpl implements UserInfoService {

    @Autowired
    private UserInfoRepositroy repositroy;

    @Override
    public UserInfo findByOpenid(String openid) {
        return repositroy.findByOpenid(openid);
    }
}
