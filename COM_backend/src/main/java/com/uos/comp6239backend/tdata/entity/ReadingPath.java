package com.uos.comp6239backend.tdata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @title: ReadingPath
 * @Author Hym
 * @Date: 2024-05-12 17:47
 * @Description: Represents a reading path taken by a reader.
 * @Version 1.0
 */
@Data
@ApiModel(description = "阅读路径实体")
@Getter
@Setter
@ToString
public class ReadingPath implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "阅读路径ID")
    private Integer readingPathId;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "故事ID")
    private Integer storyId;

    @ApiModelProperty(value = "起始阅读路径项ID")
    private Integer startReadingPathItemId;

    @ApiModelProperty(value = "读者ID")
    private Integer readerId;

    @ApiModelProperty(value = "阅读路径项列表")
    private List<ReadingPathItem> readingPathItemList;
}
