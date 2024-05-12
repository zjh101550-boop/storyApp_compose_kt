package com.uos.comp6239backend.service.impl;

import com.uos.comp6239backend.mapper.TLibraryMapper;
import com.uos.comp6239backend.mapper.TUsersMapper;
import com.uos.comp6239backend.service.TLibraryService;
import com.uos.comp6239backend.tdata.entity.TStorys;
import com.uos.comp6239backend.utils.ResponseMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public ResponseMap.ResultData tLibraryList(Map<String, Object> values) {
        List<TStorys> tStorysList = tLibraryMapper.tLibraryList(values);
        return ResponseMap.ok(tStorysList);
    }

    @Override
    @Transactional//添加事务
    public ResponseMap.ResultData tLibraryInsert(Map<String, Object> values) {
        tLibraryMapper.tLibraryInsert(values);
        return ResponseMap.ok();
    }

    @Override
    public ResponseMap.ResultData tLibraryDel(Map<String, Object> values) {
        tLibraryMapper.tLibraryDel(values);
        return ResponseMap.ok();
    }
}
