package org.dromara.core.core.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ye
 * @未读数量传输对象
 * @create 2021/12/27 11:16
 */
@Data
@AllArgsConstructor
public class UnreadNum implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long unreadSmsgNum;

    private Long unreadChatNum;

    private Long unreadTotal;

}

