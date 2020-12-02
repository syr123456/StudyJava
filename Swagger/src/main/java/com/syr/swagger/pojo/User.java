package com.syr.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;

/**
 * @author syr
 * // TODO: 2020/12/2
 */
@ApiModel("用户")
public class User {

    @ApiParam("用户名")
    String username;
    @ApiParam("密码")
    String password;

    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }
}
