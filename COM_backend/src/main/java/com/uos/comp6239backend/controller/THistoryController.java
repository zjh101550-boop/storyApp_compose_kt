package com.uos.comp6239backend.controller;

import com.uos.comp6239backend.service.TFavoriteAuthorService;
import com.uos.comp6239backend.service.THistoryService;
import com.uos.comp6239backend.utils.ResponseMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @title: THistoryController
 * @Author Hym
 * @Date: 2024-05-12 21:23
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/THistoryCtrl")
@Api(value = "历史与路径管理", tags = "History and Path Management")
public class THistoryController {
    private final static Logger log = LoggerFactory.getLogger(THistoryController.class);

    @Autowired
    private THistoryService tHistoryService;

    @PostMapping("/insertReaderHistory")
    @ApiOperation(value = "添加新的阅读历史记录", notes = "添加新的阅读历史记录")
    public ResponseMap.ResultData insertReaderHistory(@RequestBody Map<String, Object> values, HttpServletRequest request) {
        log.info("添加新的阅读历史记录: {}", values);
        return tHistoryService.insertReaderHistory(values);
    }

    @PostMapping("/updateReaderHistory")
    @ApiOperation(value = "更新现有的阅读历史", notes = "更新现有的阅读历史")
    public ResponseMap.ResultData updateReaderHistory(@RequestBody Map<String, Object> values, HttpServletRequest request) {
        log.info("更新现有的阅读历史: {}", values);
        return tHistoryService.updateReaderHistory(values);
    }

    @PostMapping("/findHistoryByReaderId")
    @ApiOperation(value = "根据读者ID查找其所有的阅读历史", notes = "根据读者ID查找其所有的阅读历史")
    public ResponseMap.ResultData findHistoryByReaderId(@RequestBody Map<String, Object> values, HttpServletRequest request) {
        log.info("根据读者ID查找其所有的阅读历史: {}", values);
        return tHistoryService.findHistoryByReaderId(values);
    }

    @PostMapping("/findHistoryByStoryId")
    @ApiOperation(value = "根据故事ID查找所有相关的阅读历史", notes = "根据故事ID查找所有相关的阅读历史")
    public ResponseMap.ResultData findHistoryByStoryId(@RequestBody Map<String, Object> values, HttpServletRequest request) {
        log.info("根据故事ID查找所有相关的阅读历史: {}", values);
        return tHistoryService.findHistoryByStoryId(values);
    }

    @PostMapping("/createReadingPath")
    @ApiOperation(value = "创建新的阅读路径", notes = "创建新的阅读路径")
    public ResponseMap.ResultData createReadingPath(@RequestBody Map<String, Object> values, HttpServletRequest request) {
        log.info("创建新的阅读路径: {}", values);
        return tHistoryService.createReadingPath(values);
    }

    @PostMapping("/updateReadingPath")
    @ApiOperation(value = "更新阅读路径", notes = "更新阅读路径")
    public ResponseMap.ResultData updateReadingPath(@RequestBody Map<String, Object> values, HttpServletRequest request) {
        log.info("更新阅读路径: {}", values);
        return tHistoryService.updateReadingPath(values);
    }

    @PostMapping("/getReadingPathById")
    @ApiOperation(value = "根据路径ID获取阅读路径详情", notes = "根据路径ID获取阅读路径详情")
    public ResponseMap.ResultData getReadingPathById(@RequestBody Map<String, Object> values, HttpServletRequest request) {
        log.info("根据路径ID获取阅读路径详情: {}", values);
        return tHistoryService.getReadingPathById(values);
    }

//    重要，测试这个api
    @PostMapping("/getPathsByStoryId")
    @ApiOperation(value = "根据故事ID获取所有相关的阅读路径", notes = "根据故事ID获取所有相关的阅读路径")
    public ResponseMap.ResultData getPathsByStoryId(@RequestBody Map<String, Object> values, HttpServletRequest request) {
        log.info("根据故事ID获取所有相关的阅读路径: {}", values);
        return tHistoryService.getPathsByStoryId(values);
    }

    @PostMapping("/insertPathItem")
    @ApiOperation(value = "添加新的阅读路径项", notes = "添加新的阅读路径项")
    public ResponseMap.ResultData insertPathItem(@RequestBody Map<String, Object> values, HttpServletRequest request) {
        log.info("添加新的阅读路径项: {}", values);
        return tHistoryService.insertPathItem(values);
    }

    @PostMapping("/updatePathItem")
    @ApiOperation(value = "更新现有的阅读路径项", notes = "更新现有的阅读路径项")
    public ResponseMap.ResultData updatePathItem(@RequestBody Map<String, Object> values, HttpServletRequest request) {
        log.info("更新现有的阅读路径项: {}", values);
        return tHistoryService.updatePathItem(values);
    }

    @PostMapping("/getPathItemsByChapterId")
    @ApiOperation(value = "根据章节ID获取所有路径项", notes = "根据章节ID获取所有路径项")
    public ResponseMap.ResultData getPathItemsByChapterId(@RequestBody Map<String, Object> values, HttpServletRequest request) {
        log.info("根据章节ID获取所有路径项: {}", values);
        return tHistoryService.getPathItemsByChapterId(values);
    }

    @PostMapping("/getPathItemById")
    @ApiOperation(value = "根据路径项ID获取详情", notes = "根据路径项ID获取详情")
    public ResponseMap.ResultData getPathItemById(@RequestBody Map<String, Object> values, HttpServletRequest request) {
        log.info("根据路径项ID获取详情: {}", values);
        return tHistoryService.getPathItemById(values);
    }
}
