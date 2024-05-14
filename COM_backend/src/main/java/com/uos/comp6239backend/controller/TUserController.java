package com.uos.comp6239backend.controller;

import com.uos.comp6239backend.service.TUsersService;
import com.uos.comp6239backend.utils.ResponseMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @title: TUserController
 * @Author Hym
 * @Date: 2024-03-18 12:03
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/TUserCtrl")
@Api(value = "用户管理", tags = "User Management")
public class TUserController {
    private final static Logger log = LoggerFactory.getLogger(TUserController.class);
    @Resource
    private TUsersService tUsersService;

    /**
     *根据读者ID展示其收藏的所有的书和剧本作者，阅读进度,返回TStoryDetail
     * @param values
     * @return
     */
    @PostMapping("/profileInsert")
    @ApiOperation(value = "profileInsert", notes = "profileInsert")
    public ResponseMap.ResultData profileInsert(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tUsersService.profileInsert(values);
    }

    /**
     *根据读者ID展示剧本作者，阅读进度等等所有的东西，十分重要
     * @param values
     * @return
     */
    @PostMapping("/profileUpdate")
    @ApiOperation(value = "profileUpdate", notes = "profileUpdate")
    public ResponseMap.ResultData profileUpdate(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tUsersService.profileUpdate(values);
    }

    /**
     *根据null展示剧本作者，阅读进度等等所有的东西，十分重要
     * @param values
     * @return
     */
    @PostMapping("/selectProfileByUserId")
    @ApiOperation(value = "selectProfileByUserId", notes = "selectProfileByUserId")
    public ResponseMap.ResultData selectProfileByUserId(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tUsersService.selectProfileByUserId(values);
    }

    @PostMapping("/selectProfileByEmail")
    @ApiOperation(value = "selectProfileByEmail", notes = "selectProfileByEmail")
    public ResponseMap.ResultData selectProfileByEmail(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tUsersService.selectProfileByEmail(values);
    }

}
