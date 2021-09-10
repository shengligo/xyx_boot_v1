package com.shell.xyxv1.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 提问标签
 * </p>
 *
 * @author shell.sjhe
 * @since 2021-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class QuizLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标签
     */
    private String label;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 标签状态(1:启用；0：未启用)
     */
    private Integer status;


}
