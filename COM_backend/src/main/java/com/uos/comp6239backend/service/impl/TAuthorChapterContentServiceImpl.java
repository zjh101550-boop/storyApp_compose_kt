package com.uos.comp6239backend.service.impl;

import com.uos.comp6239backend.mapper.TAuthorChapterContentMapper;
import com.uos.comp6239backend.mapper.TChapterContentMapper;
import com.uos.comp6239backend.service.TAuthorChapterContentService;
import com.uos.comp6239backend.service.TChapterContentService;
import com.uos.comp6239backend.tdata.entity.*;
import com.uos.comp6239backend.utils.ResponseMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
public class TAuthorChapterContentServiceImpl implements TAuthorChapterContentService {
    private final static Logger log = LoggerFactory.getLogger(TAuthorChapterContentServiceImpl.class);


    @Autowired
    private TAuthorChapterContentMapper tAuthorChapterContentMapper;

    public ResponseMap.ResultData tryGetChapter(TAuthorChapter chapter){
        TAuthorChapter newChapter=chapter;
        return ResponseMap.ok();
    }



    public ResponseMap.ResultData tAuthorUpdateStory(TAuthorStorys values){
        TStorys newStory=new TStorys();
        newStory.setStoryName(values.getStoryName());
        newStory.setStoryDescription(values.getStoryDescription());
        newStory.setStoryTrends(-1);
        newStory.setStoryCoverUrl("");
        newStory.setAuthorId(values.getAuthorId());
        newStory.setIsUsed(values.getIsUsed());
        newStory.setStoryId(values.getStoryId());
//            Insert story
            tAuthorChapterContentMapper.insertAuthorStory(newStory);

//            Insert type category
            TStoryCategory storyCategory=new TStoryCategory();
            storyCategory.setCategoryId(values.getStoryCategory());
            storyCategory.setIsUsed(1);
            storyCategory.setStoryId(values.getStoryId());
            tAuthorChapterContentMapper.insertAuthorStoryCategory(storyCategory);



//        List<TChapter> insertChapterList=new ArrayList<>();
//        List<TChapter> updateChapterList=new ArrayList<>();
        List<TContent> insertContentList=new ArrayList<>();
        List<TOption> insertOptionList=new ArrayList<>();
        for(TAuthorChapter chapter: values.getChapterList()){
            TChapter newChapter=new TChapter();
            newChapter.setChapterTitle(chapter.getChapterTitle());
            newChapter.setStoryId(chapter.getStoryId());
            newChapter.setIsEnd(chapter.getIsEnd());
            newChapter.setIsUsed(1);

                newChapter.setChapterId(chapter.getChapterId());
//                updateChapterList.add(newChapter);
                //        Update chapter
                tAuthorChapterContentMapper.updateAuthorChapter(newChapter);
                //删除此chapter.getChapterId()对应的所有content和option
                tAuthorChapterContentMapper.deleteAuthorContentByChapterId(chapter.getChapterId());
                tAuthorChapterContentMapper.deleteAuthorOptionByChapterId(chapter.getChapterId());
//                insertChapterList.add(newChapter);
            int i=0;
            if(chapter.getTContentList()!=null){
                for(TContent content: chapter.getTContentList()){
                    TContent newContent=new TContent();
                    newContent.setChapterId(content.getChapterId());
                    newContent.setContentData(content.getContentData());
                    newContent.setContentType(content.getContentType());
                    newContent.setOrder(i);
                    newContent.setIsUsed(1);
                    insertContentList.add(newContent);
                    i++;
                }
            }
            i=0;
            if(chapter.getTOptionList()!=null){
                for(TOption option: chapter.getTOptionList()){
                    TOption newOption=new TOption();
                    newOption.setChapterId(option.getOptionId());
                    newOption.setOptionName(option.getOptionName());
                    newOption.setNextChapterId(option.getNextChapterId());
                    newOption.setOrder(i);
                    newOption.setIsUsed(1);
                    insertOptionList.add(newOption);
                    i++;
                }
            }
        }
//        if(insertChapterList.size()>0){
//            tAuthorChapterContentMapper.insertAuthorChapterList(insertChapterList);
//        }
        if(insertOptionList.size()>0){
            tAuthorChapterContentMapper.insertAuthorOptionList(insertOptionList);
        }
        if(insertContentList.size()>0){
            tAuthorChapterContentMapper.insertAuthorContentList(insertContentList);
        }

//        Insert chapterlist
//        tAuthorChapterContentMapper.insertAuthorChapterList(insertChapterList);
//        Insert optionList
//        tAuthorChapterContentMapper.insertAuthorOptionList(insertOptionList);
//        insert contentList
//        tAuthorChapterContentMapper.insertAuthorContentList(insertContentList);



        return ResponseMap.ok(1);
    }

    @Override
    public ResponseMap.ResultData deleteAuthorOptionByChapterId( Integer chapterId){
        tAuthorChapterContentMapper.deleteAuthorOptionByChapterId(chapterId);
        return ResponseMap.ok();
    }

    @Override
    public ResponseMap.ResultData deleteAuthorContentByChapterId( Integer chapterId){
        tAuthorChapterContentMapper.deleteAuthorContentByChapterId(chapterId);
        return ResponseMap.ok();
    }
    @Override
    public ResponseMap.ResultData updateAuthorChapter(TChapter chapter){
        int insertLines=tAuthorChapterContentMapper.updateAuthorChapter(chapter);
        return ResponseMap.ok(insertLines);
    }

    @Override
    public ResponseMap.ResultData updateAuthorStory(TStorys story){
        int insertLines=tAuthorChapterContentMapper.updateAuthorStory(story);
        return ResponseMap.ok(insertLines>0);
    }
    @Override
    public ResponseMap.ResultData insertAuthorWithStory(TAuthorWithStory authorWithStory){
        int insertLines=tAuthorChapterContentMapper.insertAuthorWithStory(authorWithStory);
        return ResponseMap.ok(insertLines>0);
    }
    @Override
    public ResponseMap.ResultData insertAuthorStoryCategory(TStoryCategory storyCategory){
        int insertLines=tAuthorChapterContentMapper.insertAuthorStoryCategory(storyCategory);
        return ResponseMap.ok(insertLines>0);
    }

    @Override
    public ResponseMap.ResultData insertAuthorStory(TStorys story) {
        tAuthorChapterContentMapper.insertAuthorStory(story);
        return ResponseMap.ok(story.getStoryId());
    }
    @Override
    public ResponseMap.ResultData insertAuthorChapterList(List<TChapter> chapterList){
        int insertLines=tAuthorChapterContentMapper.insertAuthorChapterList(chapterList);
        return ResponseMap.ok(insertLines);
    }

    @Override
    public ResponseMap.ResultData insertAuthorOptionList(List<TOption> optionList){
        int insertLines=tAuthorChapterContentMapper.insertAuthorOptionList(optionList);
        return ResponseMap.ok(insertLines);
    }

    @Override
    public ResponseMap.ResultData insertAuthorContentList(List<TContent> contentList){
        int insertLines=tAuthorChapterContentMapper.insertAuthorContentList(contentList);
        return ResponseMap.ok(insertLines);
    }


    @Override
    public ResponseMap.ResultData tAuthorStorysByAuthorId(Map<String, Object> values){
        List<Integer> storyIdList= tAuthorChapterContentMapper.tAuthorStorysByAuthorId(values);
        List<TAuthorStorys> storyList = new ArrayList<>();
        for(Integer storyId: storyIdList){
            Map<String, Object> param = new HashMap<>();
            param.put("storyId",storyId);
            storyList.add(getFullStory(param));
        }
        return ResponseMap.ok(storyList);
    }

    public TAuthorStorys getFullStory(Map<String, Object> values){
        TAuthorStorys tAuthorStorys = tAuthorChapterContentMapper.tAuthorStoryByStoryId(values);
        List<TAuthorChapter> tAuthorChapterList = tAuthorChapterContentMapper.tAuthorChapterListByStoryId(values);
        for (TAuthorChapter item : tAuthorChapterList){
            Map<String, Object> param = new HashMap<>();
            param.put("chapterId",item.getChapterId());
            List<TContent> tContentList = tAuthorChapterContentMapper.tAuthorContentListByChapterId(param);
            List<TOption> tOptionList = tAuthorChapterContentMapper.tAuthorOptionListByChapterId(param);
            item.setTContentList(tContentList);
            item.setTOptionList(tOptionList);
        }
        tAuthorStorys.setChapterList(tAuthorChapterList);
        log.info("根据故事ID显示本故事的基本信息:"+values);
        return tAuthorStorys;
    }

    @Override
    public ResponseMap.ResultData tRootAuthorStoryByStoryId(Map<String, Object> values) {
        TAuthorStorys tAuthorStorys = tAuthorChapterContentMapper.tAuthorStoryByStoryId(values);
        List<TAuthorChapter> tAuthorChapterList = tAuthorChapterContentMapper.tAuthorChapterListByStoryId(values);
        for (TAuthorChapter item : tAuthorChapterList){
            Map<String, Object> param = new HashMap<>();
            param.put("chapterId",item.getChapterId());
            List<TContent> tContentList = tAuthorChapterContentMapper.tAuthorContentListByChapterId(param);
            List<TOption> tOptionList = tAuthorChapterContentMapper.tAuthorOptionListByChapterId(param);
            item.setTContentList(tContentList);
            item.setTOptionList(tOptionList);
        }
        tAuthorStorys.setChapterList(tAuthorChapterList);
        log.info("根据故事ID显示本故事的基本信息:"+values);
        return ResponseMap.ok(tAuthorStorys);
    }



//    根据故事ID显示本故事的基本信息
    @Override
    public ResponseMap.ResultData tAuthorStoryByStoryId(Map<String, Object> values) {
        TAuthorStorys tAuthorStorys = tAuthorChapterContentMapper.tAuthorStoryByStoryId(values);
        log.info("根据故事ID显示本故事的基本信息:"+values);
        return ResponseMap.ok(tAuthorStorys);
    }

//    根据章节ID显示本章节的基本信息
    @Override
    public ResponseMap.ResultData tAuthorChapterByChapterId(Map<String, Object> values) {
        TAuthorChapter tAuthorChapter = tAuthorChapterContentMapper.tAuthorChapterByChapterId(values);
        log.info("根据章节ID显示本章节的基本信息:"+values);
        return ResponseMap.ok(tAuthorChapter);
    }

    //    根据故事ID显示本故事的所有章节
    @Override
    public ResponseMap.ResultData tAuthorChapterListByStoryId(Map<String, Object> values) {
        List<TAuthorChapter> tAuthorChapterList = tAuthorChapterContentMapper.tAuthorChapterListByStoryId(values);
        log.info("根据故事ID显示本故事的所有章节:"+values);
        return ResponseMap.ok(tAuthorChapterList);
    }

//    根据章节ID显示本章节的所有内容
    @Override
    public ResponseMap.ResultData tAuthorContentListByChapterId(Map<String, Object> values) {
        List<TContent> tContentList = tAuthorChapterContentMapper.tAuthorContentListByChapterId(values);
        log.info("根据章节ID显示本章节的所有内容:"+values);
        return ResponseMap.ok(tContentList);
    }

//    根据章节ID显示本章节的所有选项
    @Override
    public ResponseMap.ResultData tAuthorOptionListByChapterId(Map<String, Object> values) {
        List<TOption> tOptionList = tAuthorChapterContentMapper.tAuthorOptionListByChapterId(values);
        log.info("根据章节ID显示本章节的所有选项:"+values);
        return ResponseMap.ok(tOptionList);
    }

//    根据故事ID和章节名模糊查询章节
    @Override
    public ResponseMap.ResultData tAuthorChapterByStoryIdAndChapterTitle(Map<String, Object> values) {
        List<TAuthorChapter> tAuthorChapterList = tAuthorChapterContentMapper.tAuthorChapterByStoryIdAndChapterTitle(values);
        log.info("根据故事ID和章节名模糊查询章节:"+values);
        return ResponseMap.ok(tAuthorChapterList);
    }
}
