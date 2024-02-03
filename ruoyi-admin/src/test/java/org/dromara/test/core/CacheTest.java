package org.dromara.test.core;

import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ThreadUtil;
import org.dromara.common.caffeine.utils.CacheUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheTest {

    @Test
    public void testCache() {
        CacheUtils.put("test", "test", "test");
        for (int i = 0; i < 40; i++) {
            String value = CacheUtils.get("test", "test");
            Console.log("value: {}", value);
            ThreadUtil.sleep(1000);
        }
    }
}
