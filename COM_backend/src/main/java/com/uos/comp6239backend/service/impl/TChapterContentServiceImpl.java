package com.uos.comp6239backend.service.impl;

import com.uos.comp6239backend.mapper.TChapterContentMapper;
import com.uos.comp6239backend.service.TChapterContentService;
import com.uos.comp6239backend.tdata.entity.TChapter;
import com.uos.comp6239backend.tdata.entity.TContent;
import com.uos.comp6239backend.tdata.entity.TOption;
import com.uos.comp6239backend.tdata.entity.TStorys;
import com.uos.comp6239backend.utils.ResponseMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @title: TChapterContentServiceImpl
 * @Author Hym
 * @Date: 2024-05-01 18:32
 * @Description:
 * @Version 1.0
 */
@Service
public class TChapterContentServiceImpl implements TChapterContentService {
    private final static Logger log = LoggerFactory.getLogger(TChapterContentServiceImpl.class);

    @Autowired
    private TChapterContentMapper tChapterContentMapper;


//    根据故事ID显示本故事的基本信息
    @Override
    public ResponseMap.ResultData tStoryByStoryId(Map<String, Object> values) {
        TStorys tStorys = tChapterContentMapper.tStoryByStoryId(values);
        log.info("根据故事ID显示本故事的基本信息:"+values);
        log.info("结果:"+tStorys);
        return ResponseMap.ok(tStorys);
    }

//    根据章节ID显示本章节的基本信息
    @Override
    public ResponseMap.ResultData tChapterByChapterId(Map<String, Object> values) {
        TChapter tChapter = tChapterContentMapper.tChapterByChapterId(values);
        log.info("根据章节ID显示本章节的基本信息:"+values);
        log.info("结果:"+tChapter);
        return ResponseMap.ok(tChapter);
    }

    //    根据故事ID显示本故事的所有章节
    @Override
    public ResponseMap.ResultData tChapterListByStoryId(Map<String, Object> values) {
        List<TChapter> tChapterList = tChapterContentMapper.tChapterListByStoryId(values);
        log.info("根据故事ID显示本故事的所有章节:"+values);
        log.info("结果:"+tChapterList);
        return ResponseMap.ok(tChapterList);
    }

//    根据章节ID显示本章节的所有内容
    @Override
    public ResponseMap.ResultData tContentListByChapterId(Map<String, Object> values) {
        List<TContent> tContentList = tChapterContentMapper.tContentListByChapterId(values);
        log.info("根据章节ID显示本章节的所有内容:"+values);
        log.info("结果:"+tContentList);
        return ResponseMap.ok(tContentList);
    }

//    根据章节ID显示本章节的所有选项
    @Override
    public ResponseMap.ResultData tOptionListByChapterId(Map<String, Object> values) {
        List<TOption> tOptionList = tChapterContentMapper.tOptionListByChapterId(values);
        log.info("根据章节ID显示本章节的所有选项:"+values);
        log.info("结果:"+tOptionList);
        return ResponseMap.ok(tOptionList);
    }

//    根据故事ID和章节名模糊查询章节
    @Override
    public ResponseMap.ResultData tChapterByStoryIdAndChapterTitle(Map<String, Object> values) {
        List<TChapter> tChapterList = tChapterContentMapper.tChapterByStoryIdAndChapterTitle(values);
        log.info("根据故事ID和章节名模糊查询章节:"+values);
        log.info("结果:"+tChapterList);
        return ResponseMap.ok(tChapterList);
    }
}
