package com.uos.comp6239backend.mapper;

import com.uos.comp6239backend.tdata.entity.TUsers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @title: TFavoriteAuthorMapper
 * @Author Hym
 * @Date: 2024-05-01 17:15
 * @Description:
 * @Version 1.0
 */
@Mapper
@Repository
public interface TFavoriteAuthorMapper {
    List<TUsers> tFavoriteAuthorList(Map<String, Object> values);
    List<TUsers> tFavoriteAuthorListByAuthorName(Map<String, Object> values);
    void tFavoriteAuthorInsert(Map<String, Object> values);
    void tFavoriteAuthorDel(Map<String, Object> values);
}
