package com.uos.comp6239backend.tdata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @title: TStorys
 * @Author Hym
 * @Date: 2024-04-29 10:41
 * @Description:
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@ApiModel(description = "剧本实体")
@Getter
@Setter
@ToString
public class TAuthorStorys implements Serializable {
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

    /**
     * 剧本作者ID
     */
    @ApiModelProperty(value = "剧本作者ID")
    private Integer authorId;

    /**
     * 剧本作者ID
     */
    @ApiModelProperty(value = "ALl chapter")
    private List<TAuthorChapter> chapterList;

    /**
     * 剧本作者ID
     */
    @ApiModelProperty(value = "isUsed")
    private Integer isUsed;

    @ApiModelProperty(value = "storyCategoryId")
    private Integer storyCategory;

}
