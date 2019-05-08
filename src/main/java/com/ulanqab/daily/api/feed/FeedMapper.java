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

    int createFeed(Feed feed);

    int updateFeed(Feed feed);

    int deleteFeed(Feed feed);
}
