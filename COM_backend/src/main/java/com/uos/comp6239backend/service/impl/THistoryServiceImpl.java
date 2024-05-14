package com.uos.comp6239backend.service.impl;

import com.uos.comp6239backend.mapper.TFavoriteAuthorMapper;
import com.uos.comp6239backend.mapper.THistoryMapper;
import com.uos.comp6239backend.service.THistoryService;
import com.uos.comp6239backend.tdata.entity.ReaderStoryHistory;
import com.uos.comp6239backend.tdata.entity.ReadingPath;
import com.uos.comp6239backend.tdata.entity.ReadingPathItem;
import com.uos.comp6239backend.tdata.entity.TUsers;
import com.uos.comp6239backend.utils.ResponseMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: THistoryServiceImpl
 * @Author Hym
 * @Date: 2024-05-12 21:05
 * @Description:
 * @Version 1.0
 */
@Service
public class THistoryServiceImpl implements THistoryService {

    private final static Logger log = LoggerFactory.getLogger(THistoryServiceImpl.class);

    @Autowired
    private THistoryMapper tHistoryMapper;

//    添加新的阅读历史记录
    @Transactional
    @Override
    public ResponseMap.ResultData insertReaderHistory(Map<String, Object> values) {
        tHistoryMapper.insertReaderHistory(values);
        log.info("添加新的阅读历史记录:"+values);
        return ResponseMap.ok();
    }

//    更新现有的阅读历史，例如更新笔记或当前进度。
    @Transactional
    @Override
    public ResponseMap.ResultData updateReaderHistory(Map<String, Object> values) {
        tHistoryMapper.updateReaderHistory(values);
        log.info("更新现有的阅读历史:"+values);
        return ResponseMap.ok();
    }

    @Transactional
    @Override
    public ResponseMap.ResultData findHistoryByReaderId(Map<String, Object> values) {
        List<ReaderStoryHistory> histories = tHistoryMapper.findHistoryByReaderId(values);
        log.info("根据读者ID查找其所有的阅读历史: " + values);
        log.info("结果:"+histories);
        return ResponseMap.ok(histories);
    }

    @Transactional
    @Override
    public ResponseMap.ResultData findHistoryByStoryId(Map<String, Object> values) {
        List<ReaderStoryHistory> histories = tHistoryMapper.findHistoryByStoryId(values);
        log.info("根据故事ID查找所有相关的阅读历史: " + values);
        log.info("结果:"+histories);
        return ResponseMap.ok(histories);
    }

    @Transactional
    @Override
    public ResponseMap.ResultData createReadingPath(Map<String, Object> values) {
        log.info("创建新的阅读路径: " + values);
        return ResponseMap.ok(tHistoryMapper.createReadingPath(values));
    }

    @Transactional
    @Override
    public ResponseMap.ResultData updateReadingPath(Map<String, Object> values) {
        tHistoryMapper.updateReadingPath(values);
        log.info("更新阅读路径: " + values);
        return ResponseMap.ok();
    }

    @Transactional
    @Override
    public ResponseMap.ResultData getReadingPathById(Map<String, Object> values) {
        ReadingPath path = tHistoryMapper.getReadingPathById(values);
        log.info("根据路径ID获取阅读路径详情: " + values);
        log.info("结果:"+path);
        return ResponseMap.ok(path);
    }

    @Transactional
    @Override
    public ResponseMap.ResultData getPathsByStoryId(Map<String, Object> values) {
        List<ReadingPath> paths = tHistoryMapper.getPathsByStoryId(values);
        log.info("根据故事ID获取所有相关的阅读路径: " + values);
        for(ReadingPath item : paths){
            Map<String, Object> param = new HashMap<>();
            param.put("tReadingPathId",item.getReadingPathId());
            List<ReadingPathItem> readingPathItemList = tHistoryMapper.getPathItemsByTReadingPathId(param);
            item.setReadingPathItemList(readingPathItemList);
        }
        log.info("结果:"+paths);
        return ResponseMap.ok(paths);
    }

    @Transactional
    @Override
    public ResponseMap.ResultData insertPathItem(Map<String, Object> values) {
        log.info("添加新的阅读路径项: " + values);
        return ResponseMap.ok(tHistoryMapper.insertPathItem(values));
    }

    @Transactional
    @Override
    public ResponseMap.ResultData updatePathItem(Map<String, Object> values) {
        tHistoryMapper.updatePathItem(values);
        log.info("更新现有的阅读路径项: " + values);
        return ResponseMap.ok();
    }

    @Transactional
    @Override
    public ResponseMap.ResultData getPathItemsByChapterId(Map<String, Object> values) {
        List<ReadingPathItem> pathItems = tHistoryMapper.getPathItemsByChapterId(values);
        log.info("根据章节ID获取所有路径项: " + values);
        log.info("结果:"+pathItems);
        return ResponseMap.ok(pathItems);
    }

    @Transactional
    @Override
    public ResponseMap.ResultData getPathItemById(Map<String, Object> values) {
        ReadingPathItem pathItem = tHistoryMapper.getPathItemById(values);
        log.info("根据路径项ID获取详情: " + values);
        log.info("结果:"+pathItem);
        return ResponseMap.ok(pathItem);
    }
}
