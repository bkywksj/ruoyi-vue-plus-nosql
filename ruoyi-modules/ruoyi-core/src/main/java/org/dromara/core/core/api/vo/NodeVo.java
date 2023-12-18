package org.dromara.core.core.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ls
 * @父子节点
 * @create 2022/11/20 20:59
 */
@Data
public class NodeVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标签
     */
    private String label;

    /**
     * 值
     */
    private String value;

    /**
     * 兼容前端tag标签
     */
    private Raw raw = new Raw();

    /**
     * 子节点
     */
    private List<NodeVo> children;

    @Data
    public static class Raw {
        private String listClass = "default";
    }

    public static NodeVo build(String label, String value) {
        NodeVo nodeVo = new NodeVo();
        nodeVo.setLabel(label);
        nodeVo.setValue(value);
        return nodeVo;
    }

    public static NodeVo build(String label, String value, List<NodeVo> children) {
        NodeVo nodeVo = new NodeVo();
        nodeVo.setLabel(label);
        nodeVo.setValue(value);
        nodeVo.setChildren(children);
        return nodeVo;
    }
}
