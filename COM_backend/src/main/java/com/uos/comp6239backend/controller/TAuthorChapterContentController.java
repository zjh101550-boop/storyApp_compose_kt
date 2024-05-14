package com.uos.comp6239backend.controller;

import com.uos.comp6239backend.service.TAuthorChapterContentService;
import com.uos.comp6239backend.service.TChapterContentService;
import com.uos.comp6239backend.tdata.entity.*;
import com.uos.comp6239backend.utils.ResponseMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @title: TChapterContentController
 * @Author Xiangyu
 * @Date: 2024-05-01 18:40
 * @Description:
 * @Version 1.0
 */
@RestController
@RequestMapping("/TAuthorChapterContentCtrl")
@Api(value = "章节和内容查询管理", tags = "Chapter and Content Management")
public class TAuthorChapterContentController {
    @Autowired
    private TAuthorChapterContentService tAuthorChapterContentService;

    @PostMapping("/tryGetChapter")
    @ApiOperation(value = "Update all story related informations by full story", notes = "Update all story related informations by full story")
    public ResponseMap.ResultData tryGetChapter(@RequestBody TAuthorChapter chapter, HttpServletRequest request){
        return tAuthorChapterContentService.tryGetChapter(chapter);
    }


    @PostMapping("/tAuthorUpdateStory")
    @ApiOperation(value = "Update all story related informations by full story", notes = "Update all story related informations by full story")
    public ResponseMap.ResultData tAuthorUpdateStory(@RequestBody TAuthorStorys value, HttpServletRequest request){
        return tAuthorChapterContentService.tAuthorUpdateStory(value);
    }

    @PostMapping("/deleteAuthorOptionByChapterId")
    @ApiOperation(value = "根据chapterId删除option", notes = "根据chapterId删除option")
    public ResponseMap.ResultData deleteAuthorOptionByChapterId(@RequestBody Integer chapterId, HttpServletRequest request){
        return tAuthorChapterContentService.deleteAuthorOptionByChapterId(chapterId);
    }

    @PostMapping("/deleteAuthorContentByChapterId")
    @ApiOperation(value = "根据chapterId删除content", notes = "根据chapterId删除content")
    public ResponseMap.ResultData deleteAuthorContentByChapterId(@RequestBody Integer chapterId, HttpServletRequest request){
        return tAuthorChapterContentService.deleteAuthorContentByChapterId(chapterId);
    }
    @PostMapping("/updateAuthorChapter")
    @ApiOperation(value = "根据作者ID显示该作者的所有故事", notes = "根据作者ID显示该作者的所有故事")
    public ResponseMap.ResultData updateAuthorChapter(@RequestBody TChapter chapter, HttpServletRequest request){
        return tAuthorChapterContentService.updateAuthorChapter(chapter);
    }
    @PostMapping("/updateAuthorStory")
    @ApiOperation(value = "根据作者ID显示该作者的所有故事", notes = "根据作者ID显示该作者的所有故事")
    public ResponseMap.ResultData updateAuthorStory(@RequestBody TStorys story, HttpServletRequest request){
        return tAuthorChapterContentService.updateAuthorStory(story);
    }
    @PostMapping("/insertAuthorWithStory")
    @ApiOperation(value = "根据作者ID显示该作者的所有故事", notes = "根据作者ID显示该作者的所有故事")
    public ResponseMap.ResultData insertAuthorWithStory(@RequestBody TAuthorWithStory authorWithStory, HttpServletRequest request){
        return tAuthorChapterContentService.insertAuthorWithStory(authorWithStory);
    }
    @PostMapping("/insertAuthorStoryCategory")
    @ApiOperation(value = "根据作者ID显示该作者的所有故事", notes = "根据作者ID显示该作者的所有故事")
    public ResponseMap.ResultData insertAuthorStoryCategory(@RequestBody TStoryCategory storyCategory, HttpServletRequest request){
        return tAuthorChapterContentService.insertAuthorStoryCategory(storyCategory);
    }

    @PostMapping("/insertAuthorStory")
    @ApiOperation(value = "根据作者ID显示该作者的所有故事", notes = "根据作者ID显示该作者的所有故事")
    public ResponseMap.ResultData insertAuthorStory(@RequestBody TStorys story, HttpServletRequest request) {
        return tAuthorChapterContentService.insertAuthorStory(story);
    }
    @PostMapping("/insertAuthorChapterList")
    @ApiOperation(value = "根据作者ID显示该作者的所有故事", notes = "根据作者ID显示该作者的所有故事")
    public ResponseMap.ResultData insertAuthorChapterList(@RequestBody List<TChapter> chapterList, HttpServletRequest request){
        return tAuthorChapterContentService.insertAuthorChapterList(chapterList);
    }

    @PostMapping("/insertAuthorOptionList")
    @ApiOperation(value = "根据作者ID显示该作者的所有故事", notes = "根据作者ID显示该作者的所有故事")
    public ResponseMap.ResultData insertAuthorOptionList(@RequestBody List<TOption> optionList, HttpServletRequest request){
        return tAuthorChapterContentService.insertAuthorOptionList(optionList);
    }

    @PostMapping("/insertAuthorContentList")
    @ApiOperation(value = "根据作者ID显示该作者的所有故事", notes = "根据作者ID显示该作者的所有故事")
    public ResponseMap.ResultData insertAuthorContentList(@RequestBody List<TContent> contentList, HttpServletRequest request){
        return tAuthorChapterContentService.insertAuthorContentList(contentList);
    }


    /**
     *根据作者ID显示该作者的所有故事
     * @param values
     * @return
     */
    @PostMapping("/tAuthorStorysByAuthorId")
    @ApiOperation(value = "根据作者ID显示该作者的所有故事", notes = "根据作者ID显示该作者的所有故事")
    public ResponseMap.ResultData tAuthorStorysByAuthorId(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tAuthorChapterContentService.tAuthorStorysByAuthorId(values);
    }

    /**
     *根据故事ID显示该故事下的所有信息
     * @param values
     * @return
     */
    @PostMapping("/tRootAuthorStoryByStoryId")
    @ApiOperation(value = "根据故事ID显示该故事下的所有信息", notes = "根据故事ID显示该故事下的所有信息")
    public ResponseMap.ResultData tRootAuthorStoryByStoryId(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tAuthorChapterContentService.tRootAuthorStoryByStoryId(values);
    }


    /**
     *根据故事ID显示本故事的基本信息
     * @param values
     * @return
     */
    @PostMapping("/tAuthorStoryByStoryId")
    @ApiOperation(value = "根据故事ID显示本故事的基本信息", notes = "根据故事ID显示本故事的基本信息")
    public ResponseMap.ResultData tAuthorStoryByStoryId(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tAuthorChapterContentService.tAuthorStoryByStoryId(values);
    }

    /**
     *根据章节ID显示本章节的基本信息
     * @param values
     * @return
     */
    @PostMapping("/tAuthorChapterByChapterId")
    @ApiOperation(value = "根据章节ID显示本章节的基本信息", notes = "根据章节ID显示本章节的基本信息")
    public ResponseMap.ResultData tAuthorChapterByChapterId(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tAuthorChapterContentService.tAuthorChapterByChapterId(values);
    }


    /**
     *根据故事ID显示本故事的所有章节
     * @param values
     * @return
     */
    @PostMapping("/tAuthorChapterListByStoryId")
    @ApiOperation(value = "根据故事ID显示本故事的所有章节", notes = "根据故事ID显示本故事的所有章节")
    public ResponseMap.ResultData tAuthorChapterListByStoryId(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tAuthorChapterContentService.tAuthorChapterListByStoryId(values);
    }

    /**
     *根据作者名模糊查询其所喜欢的作者
     * @param values
     * @return
     */
    @PostMapping("/tAuthorContentListByChapterId")
    @ApiOperation(value = "根据章节ID显示本章节的所有内容", notes = "根据章节ID显示本章节的所有内容")
    public ResponseMap.ResultData tAuthorContentListByChapterId(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tAuthorChapterContentService.tAuthorContentListByChapterId(values);
    }

    /**
     *添加喜欢的作者
     * @param values
     * @return
     */
    @PostMapping("/tAuthorOptionListByChapterId")
    @ApiOperation(value = "根据章节ID显示本章节的所有选项", notes = "根据章节ID显示本章节的所有选项")
    public ResponseMap.ResultData tAuthorOptionListByChapterId(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tAuthorChapterContentService.tAuthorOptionListByChapterId(values);
    }

    /**
     *根据读者ID和作者ID删除某项喜欢的作者
     * @param values
     * @return
     */
    @PostMapping("/tAuthorChapterByStoryIdAndChapterTitle")
    @ApiOperation(value = "根据故事ID和章节名模糊查询章节", notes = "根据故事ID和章节名模糊查询章节")
    public ResponseMap.ResultData tAuthorChapterByStoryIdAndChapterTitle(@RequestBody Map<String,Object> values, HttpServletRequest request){
        return tAuthorChapterContentService.tAuthorChapterByStoryIdAndChapterTitle(values);
    }
}
