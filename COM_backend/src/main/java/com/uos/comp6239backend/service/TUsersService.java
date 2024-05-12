package com.uos.comp6239backend.service;

import com.uos.comp6239backend.utils.ResponseMap;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @title: TUsersService
 * @Author Hym
 * @Date: 2024-03-18 12:55
 * @Description:
 * @Version 1.0
 */
public interface TUsersService {
    ResponseMap.ResultData tUsersInsert(Map<String, Object> values);

}
