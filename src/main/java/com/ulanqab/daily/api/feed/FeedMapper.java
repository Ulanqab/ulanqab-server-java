package com.ulanqab.daily.api.feed;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FeedMapper {

    @Select("SELECT * FROM category")
    List<Category> findCategories();

    @Select("SELECT * FROM feed")
    List<Feed> findAll();

    List<Feed> findByPage(@Param("category") int category,
                          @Param("count") int count,
                          @Param("offset") int offset);
    @Insert("INSERT INTO feed(uid,nickName,isTop,cellphone,avatar,categoryId,title,content) " +
            "VALUES (#{uid},#{nickName},#{isTop},#{cellphone},#{avatar},#{categoryId},#{title},#{content})")
    int insertFeed(Feed feed);


    @Update("UPDATE feed(id,uid,nickName,isTop,cellphone,avatar,categoryId,title,content) " +
            "VALUES (#{id},#{uid},#{nickName},#{isTop},#{cellphone},#{avatar},#{categoryId},#{title},#{content})")

    int updateFeed(Long id, Feed feed);
}
