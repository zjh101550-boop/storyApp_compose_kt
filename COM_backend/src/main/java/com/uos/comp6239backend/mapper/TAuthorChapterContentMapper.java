package com.uos.comp6239backend.mapper;

import com.uos.comp6239backend.tdata.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @title: TChapterContentMapper
 * @Author Hym
 * @Date: 2024-05-01 18:29
 * @Description:
 * @Version 1.0
 */
@Mapper
@Repository
public interface TAuthorChapterContentMapper {

    void deleteAuthorOptionByChapterId(@Param("chapterId") Integer chapterId);
    void deleteAuthorContentByChapterId(@Param("chapterId") Integer chapterId);
    int updateAuthorChapter( @Param("chapter")TChapter chapter);
    int updateAuthorStory( @Param("story")TStorys story);
    int insertAuthorStory( @Param("story")TStorys story);
    int insertAuthorStoryCategory( @Param("storyCategory")TStoryCategory storyCategory);
    int insertAuthorWithStory( @Param("authorWithStory")TAuthorWithStory authorWithStory);
    int insertAuthorChapterList( @Param("chapterList")List<TChapter> chapterList);
    int insertAuthorOptionList( @Param("optionList")List<TOption> optionList);
    int insertAuthorContentList( @Param("contentList")List<TContent> contentList);
    List<Integer> tAuthorStorysByAuthorId(Map<String, Object> values);
    TAuthorStorys tAuthorStoryByStoryId(Map<String, Object> values);
    TAuthorChapter tAuthorChapterByChapterId(Map<String, Object> values);
    List<TAuthorChapter> tAuthorChapterListByStoryId(Map<String, Object> values);
    List<TContent> tAuthorContentListByChapterId(Map<String, Object> values);
    List<TOption>  tAuthorOptionListByChapterId(Map<String, Object> values);
    List<TAuthorChapter>  tAuthorChapterByStoryIdAndChapterTitle(Map<String, Object> values);
}
