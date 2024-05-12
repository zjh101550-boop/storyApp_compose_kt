package com.uos.comp6239backend.tdata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @title: TStorys
 * @Author Hym
 * @Date: 2024-04-29 10:41
 * @Description:
 * @Version 1.0
 */
@Data
@ApiModel(description = "剧本实体")
@Getter
@Setter
@ToString
public class TStorys  implements Serializable {
    private static final long serialVersionUID = 239859184047767915L;

    /**
     * 剧本ID
     */
    @ApiModelProperty(value = "剧本ID")
    private Integer storyId;
    /**
     * 剧本名
     */
    @ApiModelProperty(value = "剧本名")
    private String storyName;
    /**
     * 剧本简介
     *
     */
    @ApiModelProperty(value = "剧本简介")
    private String storyDescription;
    /**
     * 剧本热度
     */
    @ApiModelProperty(value = "剧本热度")
    private Integer storyTrends;
    /**
     * 剧本封面
     */
    @ApiModelProperty(value = "剧本封面")
    private String storyCoverUrl;

}
