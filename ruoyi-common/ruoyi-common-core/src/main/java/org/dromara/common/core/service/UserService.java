package org.dromara.common.core.service;


import org.dromara.common.core.domain.model.LoginUser;

/**
 * 通用 用户服务
 *
 * @author Lion Li
 */
public interface UserService {

    /**
     * 查询登录用户信息
     * @return LoginUser
     */
    LoginUser getLoginUser();

}
