package org.dromara.common.oss.factory;

import org.dromara.common.core.constant.Constants;
import org.dromara.common.core.utils.SpringUtils;
import org.dromara.common.oss.core.OssClient;
import org.dromara.common.oss.properties.OssProperties;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 文件上传Factory
 *
 * @author Lion Li
 */
@Slf4j
public class OssFactory {

    private static final Map<String, OssClient> CLIENT_CACHE = new ConcurrentHashMap<>();

    /**
     * 获取默认实例 默认本地
     */
    public static OssClient instance() {
        return instance(Constants.LOCAL);
    }

    /**
     * 根据类型获取实例
     */
    public static OssClient instance(String configKey) {
        OssProperties properties = new OssProperties();
        properties.setPrefix(SpringUtils.getApplicationName());
        properties.setIsHttps("N");
        properties.setSecretKey("1");
        OssClient client = CLIENT_CACHE.get(configKey);
        if (client == null) {
            CLIENT_CACHE.put(configKey, new OssClient(configKey, properties));
            log.info("创建OSS实例 key => {}", configKey);
            return CLIENT_CACHE.get(configKey);
        }
        // 配置不相同则重新构建
        if (!client.checkPropertiesSame(properties)) {
            CLIENT_CACHE.put(configKey, new OssClient(configKey, properties));
            log.info("重载OSS实例 key => {}", configKey);
            return CLIENT_CACHE.get(configKey);
        }
        return client;
    }

}
