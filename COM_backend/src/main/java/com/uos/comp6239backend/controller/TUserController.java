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
     *添加用户
     * @param values
     * @return
     */
    @PostMapping("/tUsersInsert")
    @ApiOperation(value = "添加新用户", notes = "创建并返回一个新用户")
    public ResponseMap.ResultData tUsersInsert(@RequestBody Map<String,Object> values, HttpServletRequest request){
        log.info("添加新用户");
        return tUsersService.tUsersInsert(values);
    }
}
