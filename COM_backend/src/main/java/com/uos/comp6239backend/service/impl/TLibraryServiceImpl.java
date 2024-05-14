package com.uos.comp6239backend.service.impl;

import com.uos.comp6239backend.mapper.THistoryMapper;
import com.uos.comp6239backend.mapper.TLibraryMapper;
import com.uos.comp6239backend.mapper.TUsersMapper;
import com.uos.comp6239backend.service.TLibraryService;
import com.uos.comp6239backend.tdata.entity.ReadingPath;
import com.uos.comp6239backend.tdata.entity.TStoryDetail;
import com.uos.comp6239backend.tdata.entity.TStorys;
import com.uos.comp6239backend.tdata.entity.TStorysForUiState;
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
 * @title: TLibraryServiceImpl
 * @Author Hym
 * @Date: 2024-04-29 10:35
 * @Description:
 * @Version 1.0
 */
@Service
public class TLibraryServiceImpl implements TLibraryService {
    private final static Logger log = LoggerFactory.getLogger(TLibraryServiceImpl.class);

    @Autowired
    private TLibraryMapper tLibraryMapper;

    @Autowired
    private THistoryMapper tHistoryMapper;

    //根据读者ID展示其收藏的所有的书和剧本作者，阅读进度,返回TStoryDetail
    @Override
    public ResponseMap.ResultData selectReaderStoryDetail(Map<String, Object> values) {
        List<TStoryDetail> tStoryDetails = tLibraryMapper.selectReaderStoryDetail(values);
        log.info("根据读者ID展示其收藏的所有的书和剧本作者，阅读进度,返回TStoryDetail:"+values);
        log.info("结果:"+tStoryDetails);
        return ResponseMap.ok(tStoryDetails);
    }

    //首页展示所有的书,返回TStoryDetail:
    @Override
    public ResponseMap.ResultData selectAllStoryDetail(Map<String, Object> values) {
        List<TStoryDetail> tStoryDetails = tLibraryMapper.selectAllStoryDetail(values);
        log.info("首页展示所有的书,返回TStoryDetail:"+values);
        log.info("结果:"+tStoryDetails);
        return ResponseMap.ok(tStoryDetails);
    }

    //    根据读者ID和剧本ID和剧本作者ID展示剧本作者，阅读进度
    @Override
    public ResponseMap.ResultData tLibraryListReaderStoryForUiState(Map<String, Object> values) {
        List<TStorysForUiState> tStorysForUiStates = tLibraryMapper.tLibraryListReaderStoryForUiState(values);
        for(TStorysForUiState item : tStorysForUiStates){//这里的一个item对应一个story
            Map selectParam = new HashMap<>();
            selectParam.put("authorId",item.getAuthorId());
            selectParam.put("readerId",values.get("readerId"));
            selectParam.put("storyId",item.getStoryId());
            item.setAuthor(tLibraryMapper.tAuthorNameByAuthorId(selectParam));//设置作者名
            Integer currentProgress = tLibraryMapper.tCurrentProgressByReaderIdAndStoryId(selectParam);
            //获取到了剧本当前最新的章节历史记录头节点列表，但是item的List为空,readingPathList的长度就是头结点的个数
            List<ReadingPath> readingPathList = tHistoryMapper.findHistoryByStoryIdAndReaderId(selectParam);
            for(ReadingPath readingPathItem : readingPathList){
                Map selectParamForReadingPathItem = new HashMap();
                selectParamForReadingPathItem.put("tReadingPathId",readingPathItem.getReadingPathId());
                //获取到了剧本当前最新的章节历史记录头节点列表后，补充上item的List
                readingPathItem.setReadingPathItemList(tHistoryMapper.getPathItemsByTReadingPathId(selectParamForReadingPathItem));
            }
            item.setReadingPathList(readingPathList);
            item.setCurrentProgress(currentProgress);
            if(currentProgress == null){
                currentProgress = 3;
            }
            switch(currentProgress){
                case  0 :
                    item.setCurrentProgressText("unread");
                    break;
                case  1 :
                    item.setCurrentProgressText("reading");
                    break;
                case  2 :
                    item.setCurrentProgressText("Have readed");
                    break;
                default:
                    item.setCurrentProgressText("");
                    break;
            }
            int firstIndex = item.getReadingPathList().size() - 1;
            if(firstIndex>=0) {
                int secondIndex = item.getReadingPathList().get(firstIndex).getReadingPathItemList().size()-1;
                //设置：剧本当前被阅读到哪个章节的ID,所对应的历史记录头节点的ID
                item.setCurrentReadingPathId(item.getReadingPathList().get(firstIndex).getReadingPathId());
                if(secondIndex>=0){
                    item.setCurrentChapterId(item.getReadingPathList().get(firstIndex).getReadingPathItemList().
                            get(secondIndex).getChapterId());//取最后一个元素
                    item.setCurrentChapterName(item.getReadingPathList().get(firstIndex).getReadingPathItemList().
                            get(secondIndex).getChapterName());
                }
            }
        }
        log.info("根据读者ID和剧本ID和剧本作者ID展示剧本作者，阅读进度:"+values);
        log.info("结果:"+tStorysForUiStates);
        return ResponseMap.ok(tStorysForUiStates);
    }

    //    根据读者ID展示图书馆
    @Override
    public ResponseMap.ResultData tLibraryList(Map<String, Object> values) {
        List<TStorys> tStorysList = tLibraryMapper.tLibraryList(values);
        log.info("根据读者ID展示图书馆:"+values);
        log.info("结果:"+tStorysList);
        return ResponseMap.ok(tStorysList);
    }

//    收藏某个剧本
    @Override
    @Transactional//添加事务
    public ResponseMap.ResultData tLibraryInsert(Map<String, Object> values) {
        List<TStorys> tStorysList = tLibraryMapper.tLibraryList(values);
        int storyId = (int) values.get("storyId");
        for(TStorys item : tStorysList) {
            if (item.getStoryId() == storyId) {//已经添加过了
                return ResponseMap.ok();
            }
        }
        tLibraryMapper.tLibraryInsert(values);
        log.info("收藏某个剧本:"+values);
        return ResponseMap.ok();
    }

//    取消收藏某个剧本
    @Override
    public ResponseMap.ResultData tLibraryDel(Map<String, Object> values) {
        tLibraryMapper.tLibraryDel(values);
        log.info("取消收藏某个剧本:"+values);
        return ResponseMap.ok();
    }

    /**
     *根据null展示剧本作者，阅读进度等等所有的东西，十分重要
     * @param values
     * @return
     */
    @Override
    public ResponseMap.ResultData tLibraryListReaderStoryForUiStateByNull(Map<String, Object> values) {
        List<TStorysForUiState> tStorysForUiStates = tLibraryMapper.tLibraryListReaderStoryForUiStateByNull(values);
        for(TStorysForUiState item : tStorysForUiStates){//这里的一个item对应一个story
            Map selectParam = new HashMap<>();
            selectParam.put("authorId",item.getAuthorId());
            selectParam.put("readerId",values.get("readerId"));
            selectParam.put("storyId",item.getStoryId());
            item.setAuthor(tLibraryMapper.tAuthorNameByAuthorId(selectParam));//设置作者名
//            Integer currentProgress = tLibraryMapper.tCurrentProgressByReaderIdAndStoryId(selectParam);首页不需要看进度
            //获取到了剧本当前最新的章节历史记录头节点列表，但是item的List为空,readingPathList的长度就是头结点的个数
//            List<ReadingPath> readingPathList = tHistoryMapper.findHistoryByStoryIdAndReaderId(selectParam);首页也没有历史记录
//            for(ReadingPath readingPathItem : readingPathList){
//                Map selectParamForReadingPathItem = new HashMap();
//                selectParamForReadingPathItem.put("tReadingPathId",readingPathItem.getReadingPathId());
//                //获取到了剧本当前最新的章节历史记录头节点列表后，补充上item的List
//                readingPathItem.setReadingPathItemList(tHistoryMapper.getPathItemsByTReadingPathId(selectParamForReadingPathItem));
//            }
//            item.setReadingPathList(readingPathList);
//            item.setCurrentProgress(currentProgress);
//            switch(currentProgress){
//                case  0 :
//                    item.setCurrentProgressText("unread");
//                    break;
//                case  1 :
//                    item.setCurrentProgressText("reading");
//                    break;
//                case  2 :
//                    item.setCurrentProgressText("Have readed");
//                    break;
//            }
//            int firstIndex = item.getReadingPathList().size() - 1;
//            if(firstIndex>=0) {
//                int secondIndex = item.getReadingPathList().get(firstIndex).getReadingPathItemList().size()-1;
//                if(secondIndex>=0){
//                    item.setCurrentChapterId(item.getReadingPathList().get(firstIndex).getReadingPathItemList().
//                            get(secondIndex).getChapterId());//取最后一个元素
//                    item.setCurrentChapterName(item.getReadingPathList().get(firstIndex).getReadingPathItemList().
//                            get(secondIndex).getChapterName());
//                }
//            }
        }
        log.info("根据null展示剧本作者，阅读进度:"+values);
        log.info("结果:"+tStorysForUiStates);
        return ResponseMap.ok(tStorysForUiStates);
    }
}
