package com.uos.comp6239backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @title: TUserService
 * @Author Hym
 * @Date: 2024-03-18 12:54
 * @Description:
 * @Version 1.0
 */
@Mapper
@Repository
public interface TUsersMapper {
    void tUsersInsert(Map<String, Object> values);
}
