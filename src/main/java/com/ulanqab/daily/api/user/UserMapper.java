package com.ulanqab.daily.api.user;

import com.ulanqab.daily.api.user.model.User;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE thirdId =#{thirdId}")
    User findByThirdId(@Param("thirdId") String thirdId);

    @Select("SELECT * FROM user WHERE uid =#{uid}")
    User findByUid(@Param("uid") String uid);

    @Insert("INSERT into user(thirdId, nickName, avatar, loginAt, expiresAt, isLocked)" +
            " VALUES(#{thirdId}, #{nickName}, #{avatar}, #{loginAt}, #{expiresAt}, #{isLocked})")
    int insertUser(User token);

    int updateUserIfNecessary(@Param("uid") Long uid,
                              @Param("nickName") String nickName,
                              @Param("avatar") String avatar,
                              @Param("role") int role,
                              @Param("loginAt") Timestamp loginAt);

    @Delete("DELETE FROM user WHERE uid =#{uid}")
    int deleteByUid(Long uid);

    @Delete("DELETE FROM user WHERE nickName =#{nickName}")
    int deleteBynickName(String nickName);
}
