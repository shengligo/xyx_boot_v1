package com.shell.xyxv1.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文章分享
 * </p>
 *
 * @author shell
 * @since 2021-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Essay implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.INPUT)
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
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 文章状态(0:不可看；1：正常)
     */
    private Integer status;
    /**
     * 文章简介
     */
    private String introduce;


}
