package com.uos.comp6239backend.service;

import com.uos.comp6239backend.tdata.entity.ReaderStoryHistory;
import com.uos.comp6239backend.tdata.entity.ReadingPath;
import com.uos.comp6239backend.tdata.entity.ReadingPathItem;
import com.uos.comp6239backend.utils.ResponseMap;

import java.util.List;
import java.util.Map;

/**
 * @title: THistoryService
 * @Author Hym
 * @Date: 2024-05-12 21:03
 * @Description:
 * @Version 1.0
 */
public interface THistoryService {
    //以下是history表
    //添加新的阅读历史记录
    ResponseMap.ResultData insertReaderHistory(Map<String, Object> values);

    //更新现有的阅读历史，例如更新笔记或当前进度。
    ResponseMap.ResultData updateReaderHistory(Map<String, Object> values);

    //根据读者ID查找其所有的阅读历史
    ResponseMap.ResultData findHistoryByReaderId(Map<String, Object> values);

    //根据故事ID查找所有相关的阅读历史
    ResponseMap.ResultData findHistoryByStoryId(Map<String, Object> values);

    //t_reading_path
//    创建新的阅读路径
    ResponseMap.ResultData createReadingPath(Map<String, Object> values);

    //    更新阅读路径，如修改起始阅读路径项
    ResponseMap.ResultData updateReadingPath(Map<String, Object> values);

    //    根据路径ID获取阅读路径详情。
    ResponseMap.ResultData getReadingPathById(Map<String, Object> values);

    //    根据故事ID获取所有相关的阅读路径。
    ResponseMap.ResultData getPathsByStoryId(Map<String, Object> values);

    //以下是item表
//    添加新的阅读路径项。
    ResponseMap.ResultData insertPathItem(Map<String, Object> values);

    //    更新现有的阅读路径项，如阅读次数。
    ResponseMap.ResultData updatePathItem(Map<String, Object> values);

    //    根据章节ID获取所有路径项
    ResponseMap.ResultData getPathItemsByChapterId(Map<String, Object> values);

    //    根据路径项ID获取详情
    ResponseMap.ResultData getPathItemById(Map<String, Object> values);
}
