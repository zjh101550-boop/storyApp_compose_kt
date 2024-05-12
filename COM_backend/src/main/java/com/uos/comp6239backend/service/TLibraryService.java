package com.uos.comp6239backend.service;

import com.uos.comp6239backend.tdata.entity.TStorys;
import com.uos.comp6239backend.utils.ResponseMap;

import java.util.List;
import java.util.Map;

/**
 * @title: TLibraryService
 * @Author Hym
 * @Date: 2024-04-29 10:34
 * @Description:
 * @Version 1.0
 */
public interface TLibraryService {
    ResponseMap.ResultData tLibraryList(Map<String, Object> values);

    ResponseMap.ResultData tLibraryInsert(Map<String, Object> values);

    ResponseMap.ResultData tLibraryDel(Map<String, Object> values);
}
