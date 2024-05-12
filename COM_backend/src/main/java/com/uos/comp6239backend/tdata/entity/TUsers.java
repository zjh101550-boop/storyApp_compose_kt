package com.uos.comp6239backend.tdata.entity;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * @title: TUser
 * @Author Hym
 * @Date: 2024-03-18 12:14
 * @Description:
 * @Version 1.0
 */
@Data
@ApiModel(description = "用户实体")
@Getter
@Setter
@ToString
public class TUsers implements Serializable {
    private static final long serialVersionUID = 239859184047767915L;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Integer userId;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String username;
    /**
     * 编号
     *
     */
    @ApiModelProperty(value = "编号")
    private String password;
    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String telephone;
    /**
     * 用户头像路径
     */
    @ApiModelProperty(value = "用户头像路径")
    private String photoUrl;
    /**
     * 是否有效
     */
    @ApiModelProperty(value = "是否有效")
    private Integer isUse;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;
    /**
     * 用户类型
     */
    @ApiModelProperty(value = "用户类型")
    private Integer userType;
    /**
     * remark
     */
    @ApiModelProperty(value = "remark")
    private String remark;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer order;
    /**
     * 用户偏好的字体大小
     */
    @ApiModelProperty(value = "用户偏好的字体大小")
    private Double fontSize;
    /**
     * 点赞通知
     */
    @ApiModelProperty(value = "点赞通知")
    private Integer likeNotification;
    /**
     * 评论通知
     */
    @ApiModelProperty(value = "评论通知")
    private Integer commentNotification;
    /**
     * 喜欢的作者更新通知
     */
    @ApiModelProperty(value = "喜欢的作者更新通知")
    private Integer authorUpdateNotification;
    /**
     * 个性签名
     */
    @ApiModelProperty(value = "个性签名")
    private String selfDescription;
    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    private String birthday;
}
