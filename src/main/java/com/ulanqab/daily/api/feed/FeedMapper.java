package com.ulanqab.daily.api.feed;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FeedMapper {
    @Select("SELECT * FROM feed")
    List<Feed> findAll();

    List<Feed> findByPage(@Param("category") Integer category,
                          @Param("offset") Integer offset,
                          @Param("count") Integer count,
                          @Param("cursor") Long cursor);
}
