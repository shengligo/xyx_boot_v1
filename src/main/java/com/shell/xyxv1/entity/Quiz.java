package com.shell.xyxv1.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 提问
 * </p>
 *
 * @author shell.sjhe
 * @since 2021-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;

    private String no;
    /**
     * 提问标题
     */
    private String title;

    /**
     * 提问者（匿名代号或用户id）
     */
    private String quizzer;

    /**
     * 提问内容
     */
    private String quizContent;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 提问类型（0：匿名，1：实名）
     */
    private Integer quizType;

    /**
     * 文章状态(0:不可用；1：正常)
     */
    private Integer status;


}
