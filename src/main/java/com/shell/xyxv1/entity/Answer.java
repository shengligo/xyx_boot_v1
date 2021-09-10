package com.shell.xyxv1.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 提问回答
 * </p>
 *
 * @author shell.sjhe
 * @since 2021-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 提问编号
     */
    private Integer quizId;

    /**
     * 作者
     */
    private String answerer;

    /**
     * 回答详细内容
     */
    private String answerContent;

    /**
     * 点赞量
     */
    private Integer likePoint;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


}
