package com.uos.comp6239backend.controller;

import com.uos.comp6239backend.service.TLibraryService;
import com.uos.comp6239backend.service.TUsersService;
import com.uos.comp6239backend.utils.ResponseMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @title: TLibraryController
 * @Author Hym
 * @Date: 2024-04-29 10:19
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/TLibraryCtrl")
@Api(value = "读者喜欢的书籍/图书馆管理", tags = "library Management")
public class TLibraryController {
    private final static Logger log = LoggerFactory.getLogger(TLibraryController.class);

    @Resource
    private TLibraryService tLibraryService;

    /**
     *展示图书馆,暂时无用
     * @param values
     * @return
     */
    @PostMapping("/tLibraryLists")
    @ApiOperation(value = "展示图书馆,暂时无用", notes = "展示图书馆,暂时无用")
    public ResponseMap.ResultData tLibraryLists(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tLibraryService.tLibraryList(values);
    }

    /**
     *首页展示所有的书,返回TStoryDetail:
     * @param values
     * @return
     */
    @PostMapping("/selectAllStoryDetail")
    @ApiOperation(value = "首页展示所有的书,返回TStoryDetail:", notes = "首页展示所有的书,返回TStoryDetail:")
    public ResponseMap.ResultData selectAllStoryDetail(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tLibraryService.selectAllStoryDetail(values);
    }

    /**
     *根据读者ID展示其收藏的所有的书和剧本作者，阅读进度,返回TStoryDetail
     * @param values
     * @return
     */
    @PostMapping("/selectReaderStoryDetail")
    @ApiOperation(value = "根据读者ID展示其收藏的所有的书和剧本作者，阅读进度,返回TStoryDetail", notes = "根据读者ID展示其收藏的所有的书和剧本作者，阅读进度,返回TStoryDetail")
    public ResponseMap.ResultData selectReaderStoryDetail(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tLibraryService.selectReaderStoryDetail(values);
    }

    /**
     *根据读者ID展示剧本作者，阅读进度等等所有的东西，十分重要
     * @param values
     * @return
     */
    @PostMapping("/tLibraryListReaderStoryForUiState")
    @ApiOperation(value = "根据读者ID展示剧本作者，阅读进度等等所有的东西，十分重要", notes = "根据读者ID展示剧本作者，阅读进度等等所有的东西，十分重要")
    public ResponseMap.ResultData tLibraryListReaderStoryForUiState(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tLibraryService.tLibraryListReaderStoryForUiState(values);
    }

    /**
     *根据null展示剧本作者，阅读进度等等所有的东西，十分重要
     * @param values
     * @return
     */
    @PostMapping("/tLibraryListReaderStoryForUiStateByNull")
    @ApiOperation(value = "根据读者ID展示剧本作者，阅读进度等等所有的东西，十分重要", notes = "根据读者ID展示剧本作者，阅读进度等等所有的东西，十分重要")
    public ResponseMap.ResultData tLibraryListReaderStoryForUiStateByNull(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tLibraryService.tLibraryListReaderStoryForUiStateByNull(values);
    }

    /**
     *根据读者ID展示图书馆
     * @param values
     * @return
     */
    @PostMapping("/tLibraryList")
    @ApiOperation(value = "根据读者ID展示图书馆", notes = "根据读者ID展示图书馆")
    public ResponseMap.ResultData tLibraryList(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tLibraryService.tLibraryList(values);
    }

    /**
     *根据图书馆保存的读者和图书ID显示详情,暂时不用
     * @param values
     * @return
     */
    @PostMapping("/tLibraryInfo")
    @ApiOperation(value = "根据图书馆保存的读者和图书ID显示详情，暂时不用", notes = "根据图书馆保存的读者和图书ID显示详情，暂时不用")
    public ResponseMap.ResultData tLibraryInfo(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return null;
    }

    /**
     *根据用户ID和图书ID添加图书馆的书藉
     * @param values
     * @return
     */
    @PostMapping("/tLibraryInsert")
    @ApiOperation(value = "向图书馆内添加新图书", notes = "向图书馆内添加新图书")
    public ResponseMap.ResultData tLibraryInsert(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tLibraryService.tLibraryInsert(values);
    }

    /**
     * 根据用户ID和图书ID删除图书馆的书藉
     * @param values
     * @return
     */
    @PostMapping("/tLibraryDel")
    @ApiOperation(value = "根据用户ID和图书ID删除图书馆的书藉", notes = "根据用户ID和图书ID删除图书馆的书藉")
    public ResponseMap.ResultData tLibraryDel(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tLibraryService.tLibraryDel(values);
    }
}
