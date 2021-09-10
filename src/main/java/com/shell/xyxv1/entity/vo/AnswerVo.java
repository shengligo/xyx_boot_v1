package com.shell.xyxv1.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;

@Data
public class AnswerVo {

  /**
   * 问题id
   */
  private Integer quizId;

  /**
   * 回答id
   */
  private Integer id;
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
   * 回答创建时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date createTime;
//
//  /**
//   * 修改时间
//   */
//  private LocalDateTime updateTime;

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
  private String label;

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

//  /**
//   * 创建时间
//   */
//  private LocalDateTime createTime;
//
//  /**
//   * 修改时间
//   */
//  private LocalDateTime updateTime;

}
