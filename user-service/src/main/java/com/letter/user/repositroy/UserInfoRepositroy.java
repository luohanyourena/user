package com.letter.user.repositroy;

import com.letter.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create:luohan
 */

public interface UserInfoRepositroy extends JpaRepository<UserInfo,String> {
    UserInfo findByOpenid(String openid);
}
