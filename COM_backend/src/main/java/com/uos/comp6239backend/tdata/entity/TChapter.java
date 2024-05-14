package com.uos.comp6239backend.tdata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @title: TChapter
 * @Author Hym
 * @Date: 2024-05-01 17:41
 * @Description:
 * @Version 1.0
 */
@Data
@ApiModel(description = "章节实体")
@Getter
@Setter
@ToString
public class TChapter   implements Serializable {
    private static final long serialVersionUID = 239859184047767915L;

    /**
     * 章节ID
     */
    @ApiModelProperty(value = "章节ID")
    private Integer chapterId;
    /**
     * 章节名
     */
    @ApiModelProperty(value = "章节名")
    private String chapterTitle;
    /**
     * 剧本简介
     *
     */
    @ApiModelProperty(value = "章节编号")
    private Integer chapterNumber;
    /**
     * 所属故事ID
     */
    @ApiModelProperty(value = "所属故事ID")
    private Integer storyId;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String notes;
    /**
     * 音乐
     */
    @ApiModelProperty(value = "音乐")
    private String music;
    /**
     * 是否结束章节
     */
    @ApiModelProperty(value = "是否结束章节")
    private Integer isEnd;

    /**
     * 是否使用
     */
    @ApiModelProperty(value = "是否使用")
    private Integer isUsed;
}
