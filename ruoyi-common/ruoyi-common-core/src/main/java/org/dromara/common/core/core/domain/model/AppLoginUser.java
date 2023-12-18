package org.dromara.common.core.core.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 小程序登录用户身份权限
 *
 * @author Lion Li
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AppLoginUser extends LoginUser {

    private static final long serialVersionUID = 1L;

    /**
     * appid
     */
    private String appid;

    /**
     * unionid
     */
    private String unionid;
    /**
     * openid
     */
    private String openid;

}
