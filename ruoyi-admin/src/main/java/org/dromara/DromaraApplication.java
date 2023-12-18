package org.dromara;

import org.dromara.common.core.utils.SpringUtils;
import org.dromara.common.core.utils.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

/**
 * 启动程序
 *
 * @author Lion Li
 */

@SpringBootApplication
public class DromaraApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DromaraApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);
        System.out.println(StringUtils.format("(♥◠‿◠)ﾉﾞ  {}启动成功{}，端口：{}",
            SpringUtils.getApplicationName(), SpringUtils.getActiveProfiles(), SpringUtils.getProperty("server.port")));
    }

}
