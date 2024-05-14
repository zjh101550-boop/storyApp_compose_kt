package com.uos.comp6239backend.service;

import com.uos.comp6239backend.utils.ResponseMap;

import java.util.Map;

/**
 * @title: TChapterContentService
 * @Author Hym
 * @Date: 2024-05-01 18:31
 * @Description:
 * @Version 1.0
 */
public interface TChapterContentService {
    ResponseMap.ResultData tStoryByStoryId(Map<String, Object> values);
    ResponseMap.ResultData tChapterByChapterId(Map<String, Object> values);
    ResponseMap.ResultData tChapterListByStoryId(Map<String, Object> values);
    ResponseMap.ResultData tContentListByChapterId(Map<String, Object> values);
    ResponseMap.ResultData tOptionListByChapterId(Map<String, Object> values);
    ResponseMap.ResultData tChapterByStoryIdAndChapterTitle(Map<String, Object> values);
}
