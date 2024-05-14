package com.uos.comp6239backend.tdata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Data
@ApiModel(description = "剧本实体")
@Getter
@Setter
@ToString
public class TStorys implements Serializable {
    private static final long serialVersionUID = 239859184047767915L;

    @ApiModelProperty(value = "剧本ID")
    private Integer storyId;

    @ApiModelProperty(value = "剧本名")
    private String storyName;

    @ApiModelProperty(value = "剧本简介")
    private String storyDescription;

    @ApiModelProperty(value = "剧本热度")
    private Integer storyTrends;

    @ApiModelProperty(value = "剧本封面")
    private String storyCoverUrl;

    @ApiModelProperty(value = "剧本作者ID")
    private Integer authorId;

    @ApiModelProperty(value = "是否出版")
    private Integer isUsed;
}
