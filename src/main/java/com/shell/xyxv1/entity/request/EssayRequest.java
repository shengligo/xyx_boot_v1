package com.shell.xyxv1.entity.request;

import lombok.Data;

import java.util.Date;

@Data
public class EssayRequest {

    /**
     * 文章id
     */
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

//    /**
//     * 创建时间
//     */
//    private Date createTime;
//
//    /**
//     * 修改时间
//     */
//    private Date updateTime;

    /**
     * 文章状态(0:不可看；1：正常)
     */
    private Integer status;


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
    /**
     * 类型  0 ：插入  1：更新
     */
    private Integer type;
}
