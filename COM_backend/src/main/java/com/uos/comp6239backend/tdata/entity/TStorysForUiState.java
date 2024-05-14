package com.uos.comp6239backend.tdata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @title: TStorysForUiState
 * @Author Hym
 * @Date: 2024-05-12 5:04
 * @Description:
 * @Version 1.0
 */
@Data
@ApiModel(description = "剧本实体类，用于描述故事的基本信息")
@Getter
@Setter
@ToString
public class TStorysForUiState {
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
     * 剧本简介，提供剧本的基本概况
     */
    @ApiModelProperty(value = "剧本简介")
    private String storyDescription;

    /**
     * 剧本热度，表示剧本的流行程度或者用户的关注度
     */
    @ApiModelProperty(value = "剧本热度")
    private Integer storyTrends;

    /**
     * 剧本封面URL，用于展示剧本封面图片
     */
    @ApiModelProperty(value = "剧本封面URL")
    private String storyCoverUrl;

    /**
     * 剧本作者ID
     */
    @ApiModelProperty(value = "剧本作者ID")
    private Integer authorId;

    /**
     * 剧本作者
     */
    @ApiModelProperty(value = "剧本作者")
    private String author;

    /**
     * 剧本阅读进度，0未看，1正在看，2已看完
     */
    @ApiModelProperty(value = "剧本阅读进度")
    private Integer currentProgress;

    /**
     * 剧本阅读进度文本描述
     */
    @ApiModelProperty(value = "剧本阅读进度文本描述")
    private String currentProgressText;

    /**
     * 剧本当前被阅读到哪个章节的ID
     */
    @ApiModelProperty(value = "剧本当前被阅读到哪个章节的ID")
    private Integer currentChapterId;

    /**
     * 剧本当前被阅读到哪个章节的名称
     */
    @ApiModelProperty(value = "剧本当前被阅读到哪个章节的名称")
    private String currentChapterName;

    /**
     * 剧本当前被阅读到哪个章节的ID,所对应的历史记录头节点的ID
     */
    @ApiModelProperty(value = "剧本当前被阅读到哪个章节的ID,所对应的历史记录头节点的ID")
    private Integer currentReadingPathId;

    /**
     * 剧本当前最新的章节历史记录头节点列表
     */
    @ApiModelProperty(value = "剧本当前最新的章节历史记录头节点列表")
    private List<ReadingPath> readingPathList;
}
