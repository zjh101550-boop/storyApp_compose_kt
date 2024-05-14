package com.uos.comp6239backend.service;

import com.uos.comp6239backend.tdata.entity.TUsers;
import com.uos.comp6239backend.utils.ResponseMap;

import java.util.List;
import java.util.Map;

/**
 * @title: TFavoriteAuthorService
 * @Author Hym
 * @Date: 2024-05-01 17:19
 * @Description:
 * @Version 1.0
 */
public interface TFavoriteAuthorService {
    ResponseMap.ResultData tFavoriteAuthorList(Map<String, Object> values);
    ResponseMap.ResultData tFavoriteAuthorListByAuthorName(Map<String, Object> values);
    ResponseMap.ResultData tFavoriteAuthorInsert(Map<String, Object> values);
    ResponseMap.ResultData tFavoriteAuthorDel(Map<String, Object> values);
    ResponseMap.ResultData tFavoriteAuthorInsertByStoryId(Map<String, Object> values);
}
