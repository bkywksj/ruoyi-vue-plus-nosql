package org.dromara.common.satoken.core.event;

import org.dromara.common.core.core.domain.model.LoginUser;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;

/**
 * 错误日志对象 f_error_log
 *
 * @author ruoyi
 */
@Data
public class ErrorLogEvent {

    /**
     * 登录用户
     */
    private LoginUser loginUser;
    /**
     * 错误类型
     */
    private String errorType;
    /**
     * 错误信息
     */
    private String errorMessage;
    /**
     * 请求
     */
    private HttpServletRequest request;

    /**
     * 构建方法
     */
    public static ErrorLogEvent build(LoginUser loginUser, String errorType, String errorMessage, HttpServletRequest request) {
        ErrorLogEvent event = new ErrorLogEvent();
        event.setLoginUser(loginUser);
        event.setErrorType(errorType);
        event.setErrorMessage(errorMessage);
        event.setRequest(request);
        return event;
    }
}
