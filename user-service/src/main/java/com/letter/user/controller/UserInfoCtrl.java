package com.letter.user.controller;

import com.letter.user.constant.CookieConstant;
import com.letter.user.dataobject.UserInfo;
import com.letter.user.enums.ResultEnum;
import com.letter.user.enums.RoleEnum;
import com.letter.user.service.UserInfoService;
import com.letter.user.utils.CookieUtil;
import com.letter.user.utils.ResultVoUtil;
import com.letter.user.vo.ResultVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * create:luohan
 */
@RestController
@RequestMapping("/login")
public class UserInfoCtrl {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("buyer")
    public ResultVO buyer(@RequestParam("openid") String openid, HttpServletResponse response){
        UserInfo userInfo = userInfoService.findByOpenid(openid);
        if (userInfo==null){
            return ResultVoUtil.erro(ResultEnum.LOGIN_EORR);
        }
        if (userInfo.getRole()!= RoleEnum.BUYER.getCode()){
            return ResultVoUtil.erro(ResultEnum.ROLE_EORR);
        }
        //将用户信息存入cookie
        CookieUtil.set(response,CookieConstant.OPENID,userInfo.getOpenid(),CookieConstant.expire);

        return ResultVoUtil.seccuss();
    }

    @GetMapping("seller")
    public ResultVO seller(@RequestParam("openid") String openid, HttpServletRequest request, HttpServletResponse response){
        //判断用户是否已登录
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie!=null &&
                StringUtils.isNotBlank(stringRedisTemplate.opsForValue().get("TOKEN_"+cookie.getValue()))
            ){
            return ResultVoUtil.seccuss();
        }

        UserInfo userInfo = userInfoService.findByOpenid(openid);
        if (userInfo==null){
            return ResultVoUtil.erro(ResultEnum.LOGIN_EORR);
        }
        if (userInfo.getRole()!= RoleEnum.SELLER.getCode()){
            return ResultVoUtil.erro(ResultEnum.ROLE_EORR);
        }
        //将用户信息存入Redis
        String token =  UUID.randomUUID().toString();
        stringRedisTemplate.opsForValue().set("TOKEN_"+token,openid,CookieConstant.expire,
                TimeUnit.SECONDS);

        //将用户信息存入cookie
        CookieUtil.set(response,CookieConstant.TOKEN,token,CookieConstant.expire);

        return ResultVoUtil.seccuss();
    }
}
