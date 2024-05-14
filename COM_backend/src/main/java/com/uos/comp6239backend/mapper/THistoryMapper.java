package com.uos.comp6239backend.mapper;

import com.uos.comp6239backend.tdata.entity.ReaderStoryHistory;
import com.uos.comp6239backend.tdata.entity.ReadingPath;
import com.uos.comp6239backend.tdata.entity.ReadingPathItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @title: THistoryMapper
 * @Author Hym
 * @Date: 2024-05-12 19:13
 * @Description:
 * @Version 1.0
 */
@Mapper
@Repository
public interface THistoryMapper {
    //以下是history表
    //添加新的阅读历史记录
    void insertReaderHistory(Map<String, Object> values);

    //更新现有的阅读历史，例如更新笔记或当前进度。
    void updateReaderHistory(Map<String, Object> values);

    //根据读者ID查找其所有的阅读历史
    List<ReaderStoryHistory> findHistoryByReaderId(Map<String, Object> values);

    //根据故事ID查找所有相关的阅读历史
    List<ReaderStoryHistory> findHistoryByStoryId(Map<String, Object> values);

    //t_reading_path
//    创建新的阅读路径
    int createReadingPath(Map<String, Object> values);

//    更新阅读路径，如修改起始阅读路径项
    void updateReadingPath(Map<String, Object> values);

//    根据路径ID获取阅读路径详情。
    ReadingPath getReadingPathById(Map<String, Object> values);

//    根据故事ID获取所有相关的阅读路径。
    List<ReadingPath> getPathsByStoryId(Map<String, Object> values);

    //    根据故事ID和读者ID查找所有相关的阅读路径,但ItemList部分为空 重要
    List<ReadingPath> findHistoryByStoryIdAndReaderId(Map<String, Object> values);

    //以下是item表
//    添加新的阅读路径项。
    int insertPathItem(Map<String, Object> values);

//    更新现有的阅读路径项，如阅读次数。
    void updatePathItem(Map<String, Object> values);

//    根据章节ID获取所有路径项
    List<ReadingPathItem> getPathItemsByChapterId(Map<String, Object> values);

//    根据路径项ID获取详情
    ReadingPathItem getPathItemById(Map<String, Object> values);

    //    根据头节点ID获取所有路径项
    List<ReadingPathItem> getPathItemsByTReadingPathId(Map<String, Object> values);

}
