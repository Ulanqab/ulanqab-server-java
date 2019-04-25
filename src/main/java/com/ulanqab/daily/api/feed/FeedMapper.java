package com.ulanqab.daily.api.feed;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FeedMapper {

    @Select("SELECT * FROM category")
    List<Category> findCategories();

    List<Feed> findByPage(@Param("category") int category,
                          @Param("count") int count,
                          @Param("offset") int offset);

    Feed findFeedById(@Param("id") int id);

//    @Insert("INSERT INTO feed(uid,nickName,isTop,cellphone,avatar,categoryId,title,content) " +
//            "VALUES (#{uid},#{nickName},#{isTop},#{cellphone},#{avatar},#{categoryId},#{title},#{content})")
    int createFeed(Feed feed);

    int updateFeed(Feed feed);
}
