package com.shell.xyxv1.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文章分类
 * </p>
 *
 * @author shell
 * @since 2021-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EssaySort implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分类名
     */
    private String sortName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建id
     */
    private Integer userId;

    /**
     * 分类状态（0：未启用；1：启用）
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;


}
