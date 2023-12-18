package org.dromara.core.core.api.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ye
 * @用户活跃统计传输对象
 * @create 2022/12/7 16:05
 */
@Data
public class StatActiveUserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 今日活跃
     */
    private Long todayNum;
    /**
     * 近两日活跃
     */
    private Long twoDayNum;
    /**
     * 近七日活跃用户
     */
    private Long sevenDayNum;
    /**
     * 近一月活跃用户
     */
    private Long monthNum;

    public static StatActiveUserVo build(Long todayNum, Long twoDayNum, Long sevenDayNum, Long monthNum) {
        StatActiveUserVo statUserVo = new StatActiveUserVo();
        statUserVo.setTodayNum(todayNum);
        statUserVo.setTwoDayNum(twoDayNum);
        statUserVo.setSevenDayNum(sevenDayNum);
        statUserVo.setMonthNum(monthNum);
        return statUserVo;
    }
}
