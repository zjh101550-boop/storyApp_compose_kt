package com.uos.comp6239backend.service.impl;

import com.uos.comp6239backend.mapper.TFavoriteAuthorMapper;
import com.uos.comp6239backend.service.TFavoriteAuthorService;
import com.uos.comp6239backend.tdata.entity.TStorys;
import com.uos.comp6239backend.tdata.entity.TUsers;
import com.uos.comp6239backend.utils.ResponseMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @title: TFavoriteAuthorServiceImpl
 * @Author Hym
 * @Date: 2024-05-01 17:19
 * @Description:
 * @Version 1.0
 */
@Service
public class TFavoriteAuthorServiceImpl implements TFavoriteAuthorService {
    private final static Logger log = LoggerFactory.getLogger(TFavoriteAuthorServiceImpl.class);

    @Autowired
    private TFavoriteAuthorMapper tFavoriteAuthorMapper;

    //根据读者ID查询其所喜欢的作者
    @Override
    public ResponseMap.ResultData tFavoriteAuthorList(Map<String, Object> values) {
        List<TUsers> favoriteAuthorList = tFavoriteAuthorMapper.tFavoriteAuthorList(values);
        log.info("根据读者ID查询其所喜欢的作者:"+values);
        log.info("结果:"+favoriteAuthorList);
        return ResponseMap.ok(favoriteAuthorList);
    }

    //根据作者名模糊查询其所喜欢的作者
    @Override
    public ResponseMap.ResultData tFavoriteAuthorListByAuthorName(Map<String, Object> values) {
        List<TUsers> favoriteAuthorList = tFavoriteAuthorMapper.tFavoriteAuthorListByAuthorName(values);
        log.info("根据作者名模糊查询其所喜欢的作者:"+values);
        log.info("结果:"+favoriteAuthorList);
        return ResponseMap.ok(favoriteAuthorList);
    }

    //添加喜欢的作者
    @Override
    @Transactional//添加事务
    public ResponseMap.ResultData tFavoriteAuthorInsert(Map<String, Object> values) {
        tFavoriteAuthorMapper.tFavoriteAuthorInsert(values);
        log.info("添加喜欢的作者:"+values);
        return ResponseMap.ok();
    }

    //添加喜欢的作者
    @Override
    @Transactional//添加事务
    public ResponseMap.ResultData tFavoriteAuthorInsertByStoryId(Map<String, Object> values) {
        //根据故事ID查找作者
        int authorId = tFavoriteAuthorMapper.findAuthorIdByStoryId(values);
        values.put("authorId",authorId);

        List<TUsers> tUsersList = tFavoriteAuthorMapper.tFavoriteAuthorList(values);//得到读者喜欢的所有作者
        for(TUsers item : tUsersList) {
            if (item.getUserId() == authorId) {//已经添加过了
                return ResponseMap.ok();
            }
        }

        tFavoriteAuthorMapper.tFavoriteAuthorInsert(values);
        log.info("添加喜欢的作者:"+values);
        return ResponseMap.ok();
    }

    //根据读者ID和作者ID删除某项喜欢的作者
    @Override
    public ResponseMap.ResultData tFavoriteAuthorDel(Map<String, Object> values) {
        tFavoriteAuthorMapper.tFavoriteAuthorDel(values);
        log.info("根据读者ID和作者ID删除某项喜欢的作者:"+values);
        return ResponseMap.ok();
    }
}
