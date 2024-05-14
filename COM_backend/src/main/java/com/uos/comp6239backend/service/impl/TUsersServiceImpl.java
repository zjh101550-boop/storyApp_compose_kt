package com.uos.comp6239backend.service.impl;

import com.uos.comp6239backend.mapper.TUsersMapper;
import com.uos.comp6239backend.service.TUsersService;
import com.uos.comp6239backend.utils.ResponseMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @title: TUsersServiceImpl
 * @Author Hym
 * @Date: 2024-03-18 12:56
 * @Description:
 * @Version 1.0
 */
@Service
public class TUsersServiceImpl implements TUsersService {
    private final static Logger log = LoggerFactory.getLogger(TUsersServiceImpl.class);

    @Autowired
    private TUsersMapper tUsersMapper;

    @Transactional //添加事务
    @Override
    public ResponseMap.ResultData profileInsert(Map<String, Object> values) {
        tUsersMapper.profileInsert(values);
        log.info("profileInsert:"+values);
        return ResponseMap.ok();
    }

    @Transactional //添加事务
    @Override
    public ResponseMap.ResultData profileUpdate(Map<String, Object> values) {
        tUsersMapper.profileUpdate(values);
        log.info("profileUpdate:"+values);
        return ResponseMap.ok();
    }

    @Override
    public ResponseMap.ResultData selectProfileByUserId(Map<String, Object> values) {
        log.info("selectProfileByUserId:"+values);
        log.info("结果:"+tUsersMapper.selectProfileByUserId(values));
        return ResponseMap.ok(tUsersMapper.selectProfileByUserId(values));
    }

    @Override
    public ResponseMap.ResultData selectProfileByEmail(Map<String, Object> values) {
        log.info("selectProfileByUserId:"+values);
        return ResponseMap.ok(tUsersMapper.selectProfileByEmail(values));
    }
}
