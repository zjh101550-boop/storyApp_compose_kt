package com.uos.comp6239backend.utils;
import com.github.pagehelper.PageHelper;

import java.util.Map;
/**
 * @title: PageHelper
 * @Author Hym
 * @Date: 2024-03-15 21:07
 * @Description:
 * @Version 1.0
 */
public class PageUtil {

    public static void pageHelp(Map<String,Object> values){

        Integer pageNum = null;
        Integer pageSize = null;

        try {
            pageNum = (Integer) values.get("pageNum");
        } catch (ClassCastException e){
            e.printStackTrace();
            pageNum = Integer.parseInt((String) values.get("pageNum"));
        }

        try{
            pageSize = (Integer) values.get("pageSize");
        } catch (ClassCastException e){
            e.printStackTrace();
            pageSize = Integer.parseInt((String) values.get("pageSize"));
        }

        if(pageNum==null){
            pageNum = 1;
        }

        if(pageSize==null){
            pageSize = 1000000;
        }


        PageHelper.startPage(pageNum,pageSize);
    }

}
