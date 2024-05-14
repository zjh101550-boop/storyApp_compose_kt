package com.uos.comp6239backend.mapper;

import com.uos.comp6239backend.tdata.entity.Profile;
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

    void profileInsert(Map<String, Object> values);

    void profileUpdate(Map<String, Object> values);

    Profile selectProfileByUserId(Map<String, Object> values);
    Profile selectProfileByEmail(Map<String, Object> values);
}
