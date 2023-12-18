package org.dromara.common.excel.core;

import java.util.List;
import java.util.Map;

/**
 * excel返回对象
 *
 * @author Lion Li
 */
public interface ExcelResult<T> {

    /**
     * 表头
     */
    Map<Integer,String> getHead();

    /**
     * 对象列表
     */
    List<T> getList();

    /**
     * 错误列表
     */
    List<String> getErrorList();

    /**
     * 导入回执
     */
    String getAnalysis();
}
