package org.dromara.common.core.constant;

/**
 * 通用常量信息
 *
 * @author ruoyi
 */
public interface Constants {

    /**
     * 开发环境
     */
    String DEV = "dev";

    /**
     * 本地环境
     */
    String LOCAL = "local";

    /**
     * 生产环境
     */
    String PROD = "prod";

    /**
     * UTF-8 字符集
     */
    String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    String GBK = "GBK";

    /**
     * www主域
     */
    String WWW = "www.";

    /**
     * http请求
     */
    String HTTP = "http://";

    /**
     * https请求
     */
    String HTTPS = "https://";

    /**
     * 通用成功标识
     */
    String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    String FAIL = "1";

    /**
     * 登录成功
     */
    String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    String LOGOUT = "Logout";

    /**
     * 注册
     */
    String REGISTER = "Register";

    /**
     * 登录失败
     */
    String LOGIN_FAIL = "Error";

    /**
     * 验证码有效期（分钟）
     */
    Integer CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌
     */
    String TOKEN = "token";

    /**
     * 顶级部门id
     */
    Long TOP_PARENT_ID = 0L;

    /**
     * 资源映射路径 前缀
     */
    String RESOURCE_PREFIX = "/profile";

    /**
     * 正常
     */
    String NORMAL = "0";

    /**
     * 停用
     */
    String DISABLED = "1";

    /**
     * 需要校验路径
     */
    String CHECK = "core/check";
    /**
     * 免检路径
     */
    String NOCHECK = "core/nocheck";

}

