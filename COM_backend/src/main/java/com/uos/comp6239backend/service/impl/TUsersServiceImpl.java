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

    @Override
    @Transactional //添加事务
    public ResponseMap.ResultData tUsersInsert(Map<String, Object> values) {
        tUsersMapper.tUsersInsert(values);
        log.info("成功插入一条用户数据"); // logger.info("user {} ", userId);
        return null;
    }
}
