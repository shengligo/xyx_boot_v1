package com.shell.xyxv1.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * shell
 */
@Data
public class EssayVo implements Serializable {

  private Integer id;

  /**
   * 文章分类
   */
  private Integer sortId;

  /**
   * 标题
   */
  private String title;

  /**
   * 文章内文件路径（音频、视频等）
   */
  private String fileUrl;

  /**
   * 封面图片图片
   */
  private String faceUrl;

  /**
   * 作者
   */
  private String author;

  /**
   * 内容
   */
  private String content;

  /**
   * 创建时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date createTime;

  /**
   * 修改时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date updateTime;

  /**
   * 文章状态(0:不可看；1：正常)
   */
  private Integer status;
  /**
   * 文章简介
   */
  private String introduce;
  /**
   * 分类名称
   */
  private String sortName;


}
