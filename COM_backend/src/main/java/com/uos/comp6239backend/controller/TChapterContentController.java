package com.uos.comp6239backend.controller;

import com.uos.comp6239backend.service.TChapterContentService;
import com.uos.comp6239backend.service.TFavoriteAuthorService;
import com.uos.comp6239backend.utils.ResponseMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @title: TChapterContentController
 * @Author Hym
 * @Date: 2024-05-01 18:40
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/TChapterContentCtrl")
@Api(value = "章节和内容查询管理", tags = "Chapter and Content Management")
public class TChapterContentController {
    @Autowired
    private TChapterContentService tChapterContentService;

    /**
     *根据故事ID显示本故事的基本信息
     * @param values
     * @return
     */
    @PostMapping("/tStoryByStoryId")
    @ApiOperation(value = "根据故事ID显示本故事的基本信息", notes = "根据故事ID显示本故事的基本信息")
    public ResponseMap.ResultData tStoryByStoryId(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tChapterContentService.tStoryByStoryId(values);
    }

    /**
     *根据章节ID显示本章节的基本信息
     * @param values
     * @return
     */
    @PostMapping("/tChapterByChapterId")
    @ApiOperation(value = "根据章节ID显示本章节的基本信息", notes = "根据章节ID显示本章节的基本信息")
    public ResponseMap.ResultData tChapterByChapterId(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tChapterContentService.tChapterByChapterId(values);
    }


    /**
     *根据故事ID显示本故事的所有章节
     * @param values
     * @return
     */
    @PostMapping("/tChapterListByStoryId")
    @ApiOperation(value = "根据故事ID显示本故事的所有章节", notes = "根据故事ID显示本故事的所有章节")
    public ResponseMap.ResultData tChapterListByStoryId(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tChapterContentService.tChapterListByStoryId(values);
    }

    /**
     *根据章节ID显示本章节的所有内容
     * @param values
     * @return
     */
    @PostMapping("/tContentListByChapterId")
    @ApiOperation(value = "根据章节ID显示本章节的所有内容", notes = "根据章节ID显示本章节的所有内容")
    public ResponseMap.ResultData tContentListByChapterId(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tChapterContentService.tContentListByChapterId(values);
    }

    /**
     *根据章节ID显示本章节的所有选项
     * @param values
     * @return
     */
    @PostMapping("/tOptionListByChapterId")
    @ApiOperation(value = "根据章节ID显示本章节的所有选项", notes = "根据章节ID显示本章节的所有选项")
    public ResponseMap.ResultData tOptionListByChapterId(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tChapterContentService.tOptionListByChapterId(values);
    }

    /**
     *根据故事ID和章节名模糊查询章节
     * @param values
     * @return
     */
    @PostMapping("/tChapterByStoryIdAndChapterTitle")
    @ApiOperation(value = "根据故事ID和章节名模糊查询章节", notes = "根据故事ID和章节名模糊查询章节")
    public ResponseMap.ResultData tChapterByStoryIdAndChapterTitle(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tChapterContentService.tChapterByStoryIdAndChapterTitle(values);
    }
}
