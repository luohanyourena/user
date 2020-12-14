package com.letter.user.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * create:luohan
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {
    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

    private int role;

    private Date createTime;

    private Date updateTime;
}
