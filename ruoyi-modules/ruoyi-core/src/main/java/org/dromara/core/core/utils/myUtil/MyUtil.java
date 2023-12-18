package org.dromara.core.core.utils.myUtil;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import org.dromara.common.core.exception.ServiceException;
import org.dromara.common.core.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 我的工具类
 *
 * @author ye
 */
public class MyUtil {

    public static void main(String[] args) {
        String centerText = getCenterText("abcde", "ab", "d");
        System.out.println(centerText);
    }

    public static String encodeUrl(String url) {
        //微信公众号的redirectUrl需要如此进行编码才可以
        //redirect_uri = "https://e.xxxxxx.top/#/pages/index/index?pcode=yy1&route=/pages/index/index&a=2&b=2";
        return URLUtil.encodeQuery(url).replace("=", "%3D").replace("&", "%26");
    }

    public static Long add(Long source, Integer step) {
        if (Validator.isNull(source)) {
            source = 0L;
        }
        return source + step;
    }

    public static Long minus(Long source, long step) {
        if (Validator.isNull(source)) {
            source = 0L;
        }
        return source - step;
    }

    /* 长整数+1*/
    public static Long addOne(Long source) {
        if (Validator.isNull(source)) {
            source = 0L;
        }
        return source + 1;
    }

    /* 长整数-1*/
    public static Long minusOne(Long source) {
        if (Validator.isNull(source)) {
            source = 0L;
        }
        return source - 1;
    }

    public static BigDecimal addDecimal(BigDecimal source, BigDecimal value) {
        if (Validator.isNull(source)) {
            source = new BigDecimal(0);
        }
        if (Validator.isNull(value)) {
            value = new BigDecimal(0);
        }
        return source.add(value);
    }

    public static BigDecimal minusDecimal(BigDecimal source, BigDecimal value) {
        if (Validator.isNull(source)) {
            source = new BigDecimal(0);
        }
        if (Validator.isNull(value)) {
            value = new BigDecimal(0);
        }
        return source.subtract(value);
    }

    public static BigDecimal multiplyDecimal(BigDecimal source, BigDecimal value) {
        if (Validator.isNull(source)) {
            source = new BigDecimal(0);
        }
        if (Validator.isNull(value)) {
            value = new BigDecimal(0);
        }
        return source.multiply(value);
    }

    //四舍五入除法
    public static BigDecimal divideDecimal(BigDecimal source, BigDecimal value, Integer scale) {
        if (Validator.isNull(source)) {
            source = new BigDecimal(0);
        }
        if (Validator.isNull(value) || value.compareTo(new BigDecimal(0)) == 0) {
            throw new ServiceException("除数不为0");
        }
        if (Validator.isNull(scale)) {
            scale = 2;
        }
        return source.divide(value, scale, RoundingMode.HALF_UP);
    }


    /*文本取中间*/
    public static String getCenterText(String source, String before, String after) {
        int beforeIndex = source.indexOf(before);
        if (beforeIndex == -1) {
            return "";
        }
        String beforeAfter = source.substring(beforeIndex);
        int afterIndex = beforeAfter.indexOf(after);
        if (afterIndex == -1) {
            return "";
        }
        return beforeAfter.substring(before.length(), afterIndex);
    }

    /*获取四位验证码*/
    public static String getFourBitRandom() {
        DecimalFormat fourdf = new DecimalFormat("0000");
        return fourdf.format(RandomUtil.randomInt(10000));
    }

    /*获取六位验证码*/
    public static String getSixBitRandom() {
        DecimalFormat sixdf = new DecimalFormat("000000");
        return sixdf.format(RandomUtil.randomInt(1000000));
    }

    /**
     * 是否是中文
     */
    public static boolean isChinese(String str) {
        String regEx = "[\\u4e00-\\u9fa5]+";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /* 计算分页pageNum返回  如 1,10 就是 limit 0,10 ->(1-1)*10,10 */
    public static Integer calPageNum(Integer pageNum, Integer pageSize) {
        if (pageNum < 1) {
            pageNum = 1;
        }
        return (pageNum - 1) * pageSize;
    }

    //获取远程ip
    public static String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }

    //字符串是否包含某字符串
    public static boolean contains(String source, String str) {
        if (StringUtils.isBlank(source)) {
            return false;
        }
        if (StringUtils.isBlank(str)) {
            //str为空 则算包含
            return true;
        }
        return source.contains(str);
    }

    /**
     * 获取字符串中数字
     *
     * @return Long
     */
    public static Long getNumeric(String str) {
        String regEx = "[^0-9.]";//得加小数点 否则小数点读不出来
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String num = m.replaceAll("").trim();
        if (StrUtil.isBlank(num)) {
            return null;
        }
        return Long.valueOf(num);
    }
}
