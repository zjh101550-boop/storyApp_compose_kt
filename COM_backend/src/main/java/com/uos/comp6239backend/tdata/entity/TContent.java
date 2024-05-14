package com.uos.comp6239backend.tdata.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "内容实体")
@Getter
@Setter
@ToString
public class TContent implements Serializable {
    private static final long serialVersionUID = 234859184047767915L;

    @ApiModelProperty(value = "内容ID")
    @JsonProperty("contentId")
    private Integer contentId;

    @ApiModelProperty(value = "章节ID")
    @JsonProperty("chapterId")
    private Integer chapterId;

    @ApiModelProperty(value = "顺序")
    @JsonProperty("order")
    private Integer order;

    @ApiModelProperty(value = "本内容类别0：文字，1：图片，2：视频")
    @JsonProperty("contentType")
    private Integer contentType;

    @ApiModelProperty(value = "具体内容：文字、图片路径、视频路径")
    @JsonProperty("contentData")
    private String contentData;

    @ApiModelProperty(value = "是否使用")
    @JsonProperty("isUsed")
    private Integer isUsed;

    @ApiModelProperty(value = "内容描述（可选）")
    @JsonProperty("contentDescription")
    private String contentDescription;

    @ApiModelProperty(value = "备注")
    @JsonProperty("contentTitle")
    private String contentTitle;

    @ApiModelProperty(value = "音乐")
    @JsonProperty("music")
    private String music;
}










//package com.uos.comp6239backend.tdata.entity;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.*;
//
//import java.io.Serializable;
//
///**
// * @title: TContent
// * @Author Hym
// * @Date: 2024-05-01 17:47
// * @Description:
// * @Version 1.0
// */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ApiModel(description = "内容实体")
//@Getter
//@Setter
//@ToString
//public class TContent   implements Serializable {
//    private static final long serialVersionUID = 234859184047767915L;
//
//    /**
//     * 内容ID
//     */
//    @ApiModelProperty(value = "内容ID")
//    private Integer contentId;
//
//    /**
//     * 章节ID
//     */
//    @ApiModelProperty(value = "章节ID")
//    private Integer chapterId;
//
//    /**
//     * 顺序
//     */
//    @ApiModelProperty(value = "顺序")
//    private Integer order;
//
//    /**
//     * 本内容类别0：文字，1：图片，2：视频
//     */
//    @ApiModelProperty(value = "本内容类别0：文字，1：图片，2：视频")
//    private Integer contentType;
//
//    /**
//     * 具体内容：文字、图片路径、视频路径
//     *
//     */
//    @ApiModelProperty(value = "具体内容：文字、图片路径、视频路径")
//    private String contentData;
//
//    /**
//     * 是否使用
//     */
//    @ApiModelProperty(value = "是否使用")
//    private Integer isUsed;
//
//    /**
//     * 内容描述（可选）
//     */
//    @ApiModelProperty(value = "内容描述（可选）")
//    private String contentDescription;
//
//    /**
//     * 内容小标题（可选）
//     */
//    @ApiModelProperty(value = "备注")
//    private String contentTitle;
//
//    /**
//     * 背景音乐（可选）
//     */
//    @ApiModelProperty(value = "音乐")
//    private String music;
//
//}
