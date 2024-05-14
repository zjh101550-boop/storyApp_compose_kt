package com.uos.comp6239backend.tdata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ApiModel(description = "剧本从属关系")
@Getter
@Setter
@ToString
public class TAuthorWithStory implements Serializable {
    private static final long serialVersionUID = 239859184047767915L;

    @ApiModelProperty(value = "Author Id")
    private Integer authorId;

    @ApiModelProperty(value = "Story Id")
    private Integer storyId;

    @ApiModelProperty(value = "used or not")
    private Integer isUsed;
}
