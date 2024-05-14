package com.uos.comp6239backend.tdata.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "章节及其内容和选项实体")
@Getter
@Setter
@ToString
public class TAuthorChapter implements Serializable {
    private static final long serialVersionUID = 239857184047767915L;

    @ApiModelProperty(value = "章节ID")
    @JsonProperty("chapterId")
    private Integer chapterId;

    @ApiModelProperty(value = "章节名")
    @JsonProperty("chapterTitle")
    private String chapterTitle;

    @ApiModelProperty(value = "章节编号")
    @JsonProperty("chapterNumber")
    private Integer chapterNumber;

    @ApiModelProperty(value = "所属故事ID")
    @JsonProperty("storyId")
    private Integer storyId;

    @ApiModelProperty(value = "备注")
    @JsonProperty("notes")
    private String notes;

    @ApiModelProperty(value = "音乐")
    @JsonProperty("music")
    private String music;

    @ApiModelProperty(value = "是否结束章节")
    @JsonProperty("isEnd")
    private Integer isEnd;

    @ApiModelProperty(value = "是否使用")
    @JsonProperty("isUsed")
    private Integer isUsed;

    @ApiModelProperty(value = "内容实体列表")
    @JsonProperty("contentList")
    private List<TContent> tContentList;

    @ApiModelProperty(value = "选项实体列表")
    @JsonProperty("optionList")
    private List<TOption> tOptionList;
}








//package com.uos.comp6239backend.tdata.entity;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.*;
//
//import java.io.Serializable;
//import java.util.List;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ApiModel(description = "章节及其内容和选项实体")
//@Getter
//@Setter
//@ToString
//public class TAuthorChapter implements Serializable {
//    private static final long serialVersionUID = 239857184047767915L;
//
//    /**
//     * 章节ID
//     */
//    @ApiModelProperty(value = "章节ID")
//    private Integer chapterId;
//    /**
//     * 章节名
//     */
//    @ApiModelProperty(value = "章节名")
//    private String chapterTitle;
//    /**
//     * 剧本简介
//     *
//     */
//    @ApiModelProperty(value = "章节编号")
//    private Integer chapterNumber;
//    /**
//     * 所属故事ID
//     */
//    @ApiModelProperty(value = "所属故事ID")
//    private Integer storyId;
//    /**
//     * 备注
//     */
//    @ApiModelProperty(value = "备注")
//    private String notes;
//    /**
//     * 音乐
//     */
//    @ApiModelProperty(value = "音乐")
//    private String music;
//    /**
//     * 是否结束章节
//     */
//    @ApiModelProperty(value = "是否结束章节")
//    private Integer isEnd;
//
//    /**
//     * 是否使用
//     */
//    @ApiModelProperty(value = "是否使用")
//    private Integer isUsed;
//
//    /**
//     * 内容实体列表
//     */
//    @ApiModelProperty(value = "内容实体列表")
////    @JsonProperty("tContentList")
//    private List<TContent> tContentList;
//
//    @ApiModelProperty(value = "选项实体列表")
////    @JsonProperty("tContentList")
//    private List<TOption> tOptionList;
//}
