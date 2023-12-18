package org.dromara.common.core.constant;

/**
 * 缓存组名称常量
 * <p>
 * key 格式为 cacheNames#ttl#maxIdleTime#maxSize
 * <p>
 * ttl 过期时间 如果设置为0则不过期 默认为0
 * maxIdleTime 最大空闲时间 根据LRU算法清理空闲数据 如果设置为0则不检测 默认为0
 * maxSize 组最大长度 根据LRU算法清理溢出数据 如果设置为0则无限长 默认为0
 * <p>
 * 例子: test#60s、test#0#60s、test#0#1m#1000、test#1h#0#500
 * s秒 m分 h时 d天
 * @author Lion Li
 */
public interface CacheNames {

    /**
     * 演示案例
     */
    String DEMO_CACHE = "demo:cache#60s#10m#20";

    /**
     * 授权配置
     */
    String CLIENT_CONFIG = "client_config";

    /**
     * 系统配置
     */
    String SYS_CONFIG = "sys_config";

    /**
     * 数据字典
     */
    String SYS_DICT = "sys_dict";

    /**
     * 用户账户
     */
    String SYS_USER_NAME = "sys_user_name#30d";

    /**
     * 用户昵称
     */
    String SYS_USER_NICKNAME = "sys_user_nickname#30d";

    /**
     * 用户头像
     */
    String SYS_USER_AVATAR = "sys_user_avatar#30d";


    /**
     * 部门
     */
    String SYS_DEPT = "sys_dept#31d";

    /**
     * OSS内容
     */
    String SYS_OSS = "sys_oss#32d";

    /**
     * OSS配置
     */
    String SYS_OSS_CONFIG = "sys_oss_config";

    /**
     * 十秒
     */
    String TEN_SECONDS = "second:cache#10s#10s";

    /**
     * 一分钟
     */
    String MINUTE_CACHE = "minute:cache#60s#60s";

    /**
     * 小时缓存
     */
    String HOUR_CACHE = "hour:cache#1h#1h";

    /**
     * 一天缓存
     */
    String DAY_CACHE = "day:cache#24h#24h";

    /**
     * 广告缓存
     */
    String AD_CACHE = "ad:cache#10m#10m";

    /**
     * 消息缓存
     */
    String MSG_CACHE = "msg:cache#100m#100m";
}
