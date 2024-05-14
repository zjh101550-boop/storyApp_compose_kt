package com.uos.comp6239backend.controller;

import com.uos.comp6239backend.service.TFavoriteAuthorService;
import com.uos.comp6239backend.utils.ResponseMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @title: TFavoriteAuthorController
 * @Author Hym
 * @Date: 2024-05-01 17:26
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/TFavoriteAuthorCtrl")
@Api(value = "读者喜欢的作者管理", tags = "Favorite Author Management")
public class TFavoriteAuthorController {
    @Autowired
    private TFavoriteAuthorService tFavoriteAuthorService;

    @GetMapping("/deviceInfo")
    public ResponseMap.ResultData deviceInfo(@RequestParam Integer deviceId){
        return ResponseMap.ok();
    }
    /**
     *根据读者ID查询其所喜欢的作者
     * @param values
     * @return
     */
    @PostMapping("/tFavoriteAuthorList")
    @ApiOperation(value = "根据读者ID查询其所喜欢的作者", notes = "根据读者ID查询其所喜欢的作者")
    public ResponseMap.ResultData tFavoriteAuthorList(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tFavoriteAuthorService.tFavoriteAuthorList(values);
    }

    /**
     *根据作者名模糊查询其所喜欢的作者
     * @param values
     * @return
     */
    @PostMapping("/tFavoriteAuthorListByAuthorName")
    @ApiOperation(value = "根据作者名模糊查询其所喜欢的作者", notes = "根据作者名模糊查询其所喜欢的作者")
    public ResponseMap.ResultData tFavoriteAuthorListByAuthorName(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tFavoriteAuthorService.tFavoriteAuthorListByAuthorName(values);
    }

    /**
     *添加喜欢的作者
     * @param values
     * @return
     */
    @PostMapping("/tFavoriteAuthorInsert")
    @ApiOperation(value = "添加喜欢的作者", notes = "添加喜欢的作者")
    public ResponseMap.ResultData tFavoriteAuthorInsert(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tFavoriteAuthorService.tFavoriteAuthorInsert(values);
    }

    /**
     *添加喜欢的作者通过故事ID
     * @param values
     * @return
     */
    @PostMapping("/tFavoriteAuthorInsertByStoryId")
    @ApiOperation(value = "添加喜欢的作者通过故事ID", notes = "添加喜欢的作者通过故事ID")
    public ResponseMap.ResultData tFavoriteAuthorInsertByStoryId(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tFavoriteAuthorService.tFavoriteAuthorInsertByStoryId(values);
    }

    /**
     *根据读者ID和作者ID删除某项喜欢的作者
     * @param values
     * @return
     */
    @PostMapping("/tFavoriteAuthorDel")
    @ApiOperation(value = "根据读者ID和作者ID删除某项喜欢的作者", notes = "根据读者ID和作者ID删除某项喜欢的作者")
    public ResponseMap.ResultData tFavoriteAuthorDel(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tFavoriteAuthorService.tFavoriteAuthorDel(values);
    }

}
