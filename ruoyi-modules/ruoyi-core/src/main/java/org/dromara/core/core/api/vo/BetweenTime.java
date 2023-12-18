package org.dromara.core.core.api.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ry
 * @默认起始终止时间
 * @create 2022/6/8 15:40
 */
@Data
public class BetweenTime implements Serializable {

    private static final long serialVersionUID = 1L;

    private String start;

    private String end;
}
