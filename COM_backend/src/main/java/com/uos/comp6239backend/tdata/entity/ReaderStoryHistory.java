package com.uos.comp6239backend.tdata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

/**
 * @title: ReaderStoryHistory
 * @Author Hym
 * @Date: 2024-05-12 17:47
 * @Description: Represents the reading history of a reader for a specific story.
 * @Version 1.0
 */
@Data
@ApiModel(description = "读者故事历史实体")
@Getter
@Setter
@ToString
public class ReaderStoryHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "读者ID")
    private Integer readerId;

    @ApiModelProperty(value = "故事ID")
    private Integer storyId;

    @ApiModelProperty(value = "是否使用", example = "0: 不使用, 1: 使用")
    private Integer isUsed;

    @ApiModelProperty(value = "笔记")
    private String notes;

    @ApiModelProperty(value = "当前进度")
    private Integer currentProgress;
}

