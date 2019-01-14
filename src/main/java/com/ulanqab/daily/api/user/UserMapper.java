package com.ulanqab.daily.api.user;

import com.ulanqab.daily.api.user.model.User;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE uid =#{uid}")
    User findByUid(@Param("uid") String uid);

    @Insert("INSERT into user(nickName, avatar, loginAt, expiresAt, isLocked)" +
            " VALUES(#{nickName}, #{avatar}, #{loginAt}, #{expiresAt}, #{isLocked})")
    int insertUser(User token);

    int updateUserIfNecessary(@Param("uid") Long uid,
                              @Param("password") String password,
                              @Param("loginAt") Timestamp loginAt,
                              @Param("mobile") String mobile,
                              @Param("appId") int appId);

    @Delete("DELETE FROM user WHERE uid =#{uid}")
    int deleteByUid(Long uid);

    @Delete("DELETE FROM user WHERE nickName =#{nickName}")
    int deleteBynickName(String nickName);
}
