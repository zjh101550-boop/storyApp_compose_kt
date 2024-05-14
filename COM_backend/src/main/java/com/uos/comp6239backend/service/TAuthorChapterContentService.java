package com.uos.comp6239backend.service;

import com.uos.comp6239backend.tdata.entity.*;
import com.uos.comp6239backend.utils.ResponseMap;

import java.util.List;
import java.util.Map;

/**
 * @title: TChapterContentService
 * @Author Hym
 * @Date: 2024-05-01 18:31
 * @Description:
 * @Version 1.0
 */
public interface TAuthorChapterContentService {

    ResponseMap.ResultData tryGetChapter(TAuthorChapter chapter);

    ResponseMap.ResultData updateAuthorStory(TStorys story);
    ResponseMap.ResultData insertAuthorStory(TStorys story);
    ResponseMap.ResultData insertAuthorStoryCategory(TStoryCategory storyCategory);
    ResponseMap.ResultData insertAuthorWithStory(TAuthorWithStory authorWithStory);

    ResponseMap.ResultData  deleteAuthorOptionByChapterId( Integer chapterId);
    ResponseMap.ResultData  deleteAuthorContentByChapterId( Integer chapterId);

    ResponseMap.ResultData updateAuthorChapter(TChapter chapter);
    ResponseMap.ResultData insertAuthorChapterList(List<TChapter> chapterList);
    ResponseMap.ResultData insertAuthorOptionList(List<TOption> optionList);
    ResponseMap.ResultData insertAuthorContentList(List<TContent> contentList);
    ResponseMap.ResultData tAuthorUpdateStory(TAuthorStorys values);
    ResponseMap.ResultData tAuthorStorysByAuthorId(Map<String, Object> values);
    ResponseMap.ResultData tAuthorStoryByStoryId(Map<String, Object> values);
    ResponseMap.ResultData tAuthorChapterByChapterId(Map<String, Object> values);
    ResponseMap.ResultData tAuthorChapterListByStoryId(Map<String, Object> values);
    ResponseMap.ResultData tAuthorContentListByChapterId(Map<String, Object> values);
    ResponseMap.ResultData tAuthorOptionListByChapterId(Map<String, Object> values);
    ResponseMap.ResultData tAuthorChapterByStoryIdAndChapterTitle(Map<String, Object> values);
    ResponseMap.ResultData tRootAuthorStoryByStoryId(Map<String, Object> values);
}
