package com.shell.xyxv1.entity.request;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class AnswerRequest {

  /**
   * 回答编号
   */
  private Integer id;
  /**
   * 问题编号
   */
  private Integer quizId;
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
  private LocalDateTime createTime;

  /**
   * 修改时间
   */
  private LocalDateTime updateTime;

  /**
   * 提问类型（0：匿名，1：实名）
   */
  private Integer quizType;

  /**
   * 文章状态(0:不可用；1：正常)
   */
  private Integer status;

  /**
   * 标签
   */
  private List<String> label;

  /**
   * 分页
   */
  private Integer pageNum;
  private Integer pageSize;

  /**
   * 查询需要
   */
  private Date startTime;
  private Date endTime;
}
