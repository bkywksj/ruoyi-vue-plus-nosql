package org.dromara.core.core.api.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ye
 * @用户新增统计传输对象
 * @create 2022/12/7 16:05
 */
@Data
public class StatUserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 今日新增
     */
    private Long todayNum;
    /**
     * 昨日新增用户
     */
    private Long yesterdayNum;
    /**
     * 近七日新增用户
     */
    private Long sevenDayNum;
    /**
     * 总用户数
     */
    private Long total;

    public static StatUserVo build (Long todayNum, Long yesterdayNum, Long sevenDayNum,Long total) {
        StatUserVo statUserVo = new StatUserVo();
        statUserVo.setTodayNum(todayNum);
        statUserVo.setYesterdayNum(yesterdayNum);
        statUserVo.setSevenDayNum(sevenDayNum);
        statUserVo.setTotal(total);
        return statUserVo;
    }
}
