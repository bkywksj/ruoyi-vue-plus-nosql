package org.dromara.common.web.config;

import org.dromara.common.web.core.I18nLocaleResolver;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;

/**
 * 国际化配置
 *
 * @author Lion Li
 */
@AutoConfiguration(before = WebMvcAutoConfiguration.class)
public class I18nConfig {

    @Bean
    public LocaleResolver localeResolver() {
        return new I18nLocaleResolver();
    }

    /**
     * @AutoConfiguration(before = WebMvcAutoConfiguration.class)可以解决下列报错 设置加载顺序
     * The bean 'localeResolver', defined in class path resource
     * [com/ruoyi/common/web/config/I18nConfig.class], could not be registered.
     * A bean with that name has already been defined in class path resource
     * [org/springframework/boot/autoconfigure/web/servlet/
     * WebMvcAutoConfiguration$EnableWebMvcConfiguration.class] and overriding is disabled.
     * */
}
