package com.uos.comp6239backend.tdata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @title: ReadingPathItem
 * @Author Hym
 * @Date: 2024-05-12 20:38
 * @Description:
 * @Version 1.0
 */
@Data
@ApiModel(description = "阅读路径项实体")
@Getter
@Setter
@ToString
public class ReadingPathItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "阅读路径项ID")
    private Integer readingPathItemId;

    @ApiModelProperty(value = "章节ID")
    private Integer chapterId;

    @ApiModelProperty(value = "章节Name")
    private String chapterName;

    @ApiModelProperty(value = "阅读次数")
    private Date readingTimes;

    @ApiModelProperty(value = "下一个阅读路径ID")
    private Integer nextReadingPathId;

    @ApiModelProperty(value = "阅读时间")
    private Date readingTime;

    @ApiModelProperty(value = "顺序")
    private Integer order;

    @ApiModelProperty(value = "所属章节路径记录头节点ID")
    private Integer tReadingPathId;
}
