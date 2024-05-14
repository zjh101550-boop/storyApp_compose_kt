package com.uos.comp6239backend.tdata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @title: TStoryDetail
 * @Author Hym
 * @Date: 2024-05-12 7:12
 * @Description:
 * @Version 1.0
 */
@Data
@ApiModel(description = "读者收藏的剧本详细信息实体")
@Getter
@Setter
@ToString
public class TStoryDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 剧本ID
     */
    @ApiModelProperty(value = "剧本ID")
    private Integer storyId;

    /**
     * 剧本名称
     */
    @ApiModelProperty(value = "剧本名称")
    private String storyName;

    /**
     * 剧本简介
     */
    @ApiModelProperty(value = "剧本简介")
    private String storyDescription;

    /**
     * 剧本热度
     */
    @ApiModelProperty(value = "剧本热度")
    private Integer storyTrends;

    /**
     * 剧本封面URL
     */
    @ApiModelProperty(value = "剧本封面URL")
    private String storyCoverUrl;

    /**
     * 剧本作者ID
     */
    @ApiModelProperty(value = "剧本作者ID")
    private Integer authorId;

    /**
     * 剧本作者名
     */
    @ApiModelProperty(value = "剧本作者名")
    private String authorName;

    /**
     * 阅读进度
     */
    @ApiModelProperty(value = "阅读进度")
    private Integer currentProgress;
}
