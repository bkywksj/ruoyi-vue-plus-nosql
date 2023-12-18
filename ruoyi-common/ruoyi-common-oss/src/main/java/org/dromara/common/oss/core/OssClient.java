package org.dromara.common.oss.core;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.Getter;
import org.dromara.common.core.config.RuoYiConfig;
import org.dromara.common.core.constant.Constants;
import org.dromara.common.core.utils.DateUtils;
import org.dromara.common.core.utils.ServletUtils;
import org.dromara.common.core.utils.SpringUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.core.utils.file.FileUploadUtils;
import org.dromara.common.core.utils.file.FileUtils;
import org.dromara.common.oss.constant.OssConstant;
import org.dromara.common.oss.entity.UploadResult;
import org.dromara.common.oss.exception.OssException;
import org.dromara.common.oss.properties.OssProperties;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

/**
 * 本地上传
 *
 * @author Lion Li
 */
public class OssClient {

    @Getter
    private final String configKey;

    private final OssProperties properties;

    public OssClient(String configKey, OssProperties ossProperties) {
        this.configKey = configKey;
        this.properties = ossProperties;
    }

    public UploadResult upload(byte[] data, String path, String contentType) {
        return upload(new ByteArrayInputStream(data), path, contentType);
    }

    public UploadResult upload(InputStream inputStream, String path, String contentType) {
        if (!(inputStream instanceof ByteArrayInputStream)) {
            inputStream = new ByteArrayInputStream(IoUtil.readBytes(inputStream));
        }
        try {
            //本地上传
            return localUploadSuffix(inputStream, path, contentType);
        } catch (Exception e) {
            throw new OssException("上传文件失败，请检查配置信息:[" + e.getMessage() + "]");
        }
    }

    public UploadResult upload(File file, String path) {
        try {
            return localUploadSuffix(FileUtil.getInputStream(file), path, null);
        } catch (Exception e) {
            throw new OssException("上传文件失败，请检查配置信息:[" + e.getMessage() + "]");
        }
    }

    public void delete(String path) {
        path = path.replace(getUrl() + "/", "");
        try {
            //本地删除
            FileUtils.del(RuoYiConfig.getProfile() + "/" + path.substring(8));
        } catch (Exception e) {
            throw new OssException("删除文件失败，请检查配置信息:[" + e.getMessage() + "]");
        }
    }

    public UploadResult uploadSuffix(byte[] data, String suffix, String contentType) {
        return upload(data, getPath(properties.getPrefix(), suffix), contentType);
    }

    public UploadResult uploadSuffix(InputStream inputStream, String suffix, String contentType) {
        return upload(inputStream, getPath(properties.getPrefix(), suffix), contentType);
    }

    public UploadResult uploadSuffix(File file, String suffix) {
        return upload(file, getPath(properties.getPrefix(), suffix));
    }

    /**
     * 获取文件流
     */
    public InputStream getObjectContent(String path) {
        path = path.replace(getUrl() + "/", "");
        return FileUtil.getInputStream(RuoYiConfig.getProfile() + "/" + path.substring(8));
    }

    /**
     * 获取文件路径前部分
     */
    public String getUrl() {
        if (!Constants.PROD.equals(SpringUtils.getActiveProfile()) || StringUtils.isBlank(properties.getDomain())) {
            //非生产环境则返回本地路径
            return Constants.HTTP + NetUtil.getLocalhostStr() + ":" + SpringUtils.getProperty("server.port");
        }
        //生产环境判断配置有域名则把ip替换为域名，没有则返回ip，有域名判断是否需要https
        HttpServletRequest request = ServletUtils.getRequest();
        StringBuffer url = request.getRequestURL();
        String contextPath = request.getServletContext().getContextPath();
        String res = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(contextPath).toString();
        //有域名
        if (OssConstant.IS_HTTPS.equals(properties.getIsHttps())) {
            //需要https
            return res.replace(Constants.HTTP, Constants.HTTPS).replace(request.getServerName(), properties.getDomain());
        } else {
            //不需要https
            return res.replace(request.getServerName(), properties.getDomain());
        }
    }


    /**
     * 获取文件路径
     *
     * @param prefix 目录前缀
     * @param suffix 文件后缀
     * @return 文件路径
     */
    public String getPath(String prefix, String suffix) {
        // 生成uuid
        String uuid = IdUtil.fastSimpleUUID();
        // 文件路径
        String path = DateUtils.datePath() + "/" + uuid;
        if (StringUtils.isNotBlank(prefix)) {
            path = prefix + "/" + path;
        }
        return path + suffix;
    }

    /**
     * 检查配置是否相同
     */
    public boolean checkPropertiesSame(OssProperties properties) {
        return this.properties.equals(properties);
    }

    /**
     * 本地上传方法
     *
     * @param inputStream 文件流
     * @param path        文件路径
     * @param contentType 文件类型
     * @return 上传结果
     */
    private UploadResult localUploadSuffix(InputStream inputStream, String path, String contentType) {
        // 声明文件名
        String fileName = FileUploadUtils.upload(inputStream, path, contentType);
        String url = getUrl() + fileName;
        return UploadResult.builder().filename(fileName).url(url).build();
    }


}
