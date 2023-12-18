package org.dromara.common.web.core;


import org.dromara.common.core.core.domain.R;
import org.dromara.common.core.core.domain.dto.RoleDTO;
import org.dromara.common.core.core.domain.model.LoginUser;
import org.dromara.common.core.exception.ServiceException;
import org.dromara.common.core.service.UserService;
import org.dromara.common.core.utils.ServletUtils;
import org.dromara.common.core.utils.StreamUtils;
import org.dromara.common.core.utils.SpringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * web层通用数据处理
 *
 * @author Lion Li
 */
public class BaseController {

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected R<Void> toAjax(int rows) {
        return rows > 0 ? R.ok() : R.fail();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected R<Void> toAjax(boolean result) {
        return result ? R.ok() : R.fail();
    }

    /**
     * 页面跳转
     */
    public void redirect(String url) {
        HttpServletResponse response = ServletUtils.getResponse();
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        return StringUtils.format("redirect:{}", url);
    }

    /**
     * 获取用户缓存信息
     */
    public LoginUser getLoginUser() {
        return SpringUtils.getBean(UserService.class).getLoginUser();
    }

    /**
     * 获取登录用户id
     */
    public Long getUserId() {
        return getLoginUser().getUserId();
    }

    /**
     * 获取登录部门id
     */
    public Long getDeptId() {
        return getLoginUser().getDeptId();
    }

    /**
     * 获取登录用户名
     */
    public String getUsername() {
        return getLoginUser().getUsername();
    }


    //返回R封装
    public <T> R<T> ok() {
        return R.ok();
    }

    public <T> R<T> ok(T data) {
        return R.ok(data);
    }

    public <T> R<T> ok(String msg) {
        return R.ok(msg);
    }

    public <T> R<T> ok(String msg, T data) {
        return R.ok(msg, data);
    }

    public <T> R<T> fail() {
        return R.fail();
    }

    public <T> R<T> fail(String msg) {
        return R.fail(msg);
    }

    public <T> R<T> fail(T data) {
        return R.fail(data);
    }

    public <T> R<T> fail(String msg, T data) {
        return R.fail(msg, data);
    }

    //可以自定义code
    public <T> R<T> fail(int code, String msg) {
        return R.fail(code, msg);
    }

    //校验管理员
    public void checkAdmin() {
        if (!isAdmin()) {
            throw new ServiceException("权限不足");
        }
    }

    //是否管理员(不传参)
    public Boolean isAdmin() {
        LoginUser loginUser = getLoginUser();
        return isAdmin(loginUser);
    }

    //是否管理员(传参)
    public Boolean isAdmin(LoginUser loginUser) {
        List<RoleDTO> filter = StreamUtils.filter(loginUser.getRoles(),
            roleDTO -> roleDTO.getRoleKey().contains("admin"));
        return !filter.isEmpty();
    }

}
