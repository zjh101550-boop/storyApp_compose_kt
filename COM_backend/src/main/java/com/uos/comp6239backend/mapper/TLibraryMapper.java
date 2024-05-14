package com.uos.comp6239backend.mapper;

import com.uos.comp6239backend.tdata.entity.TStoryDetail;
import com.uos.comp6239backend.tdata.entity.TStorys;
import com.uos.comp6239backend.tdata.entity.TStorysForUiState;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @title: TLibraryMapper
 * @Author Hym
 * @Date: 2024-04-29 10:35
 * @Description:
 * @Version 1.0
 */
@Mapper
@Repository
public interface TLibraryMapper {
    List<TStoryDetail> selectReaderStoryDetail(Map<String, Object> values);

    List<TStoryDetail> selectAllStoryDetail(Map<String, Object> values);

    List<TStorysForUiState> tLibraryListReaderStoryForUiState(Map<String, Object> values);

    List<TStorysForUiState> tLibraryListReaderStoryForUiStateByNull(Map<String, Object> values);

    String tAuthorNameByAuthorId(Map<String, Object> values);

    Integer tCurrentProgressByReaderIdAndStoryId(Map<String, Object> values);

    List<TStorys> tLibraryList(Map<String, Object> values);

    void tLibraryInsert(Map<String, Object> values);

    void tLibraryDel(Map<String, Object> values);
}
