package com.ulanqab.daily.api.user;

import com.ulanqab.daily.LocalConstants;
import com.ulanqab.daily.api.user.model.*;
import com.ulanqab.daily.jwt.Jwt;
import com.ulanqab.daily.utils.AesCbcUtil;
import com.ulanqab.daily.utils.JsonUtils;
import com.ulanqab.daily.wrapper.UlanqabResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private LocalConstants constants = new LocalConstants();

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public UlanqabResponse<LoginResult> login(@RequestBody String params) throws IOException {

        Long loginTime = System.currentTimeMillis();
        Long expiredTime = System.currentTimeMillis() + 1000*60*24;

        CommonBean commonBean = JsonUtils.jsonToObject(params, CommonBean.class);

        Session session = getSession(commonBean.getCode());
        AccessToken accessToken = getAccessToken();
        try {
            String userInfoStr = AesCbcUtil.decrypt(commonBean.getEncryptedData(), session.getSession_key(), commonBean.getIv(), "UTF-8");
            UserInfo userInfo = JsonUtils.jsonToObject(userInfoStr, UserInfo.class);

            User userResult = userMapper.findByThirdId(userInfo.getOpenId());
            if (userResult == null) {
                User user = new User(userInfo.getOpenId()
                        ,userInfo.getNickName()
                        , userInfo.getAvatarUrl()
                        , new Timestamp(loginTime)
                        , new Timestamp(expiredTime));
                userMapper.insertUser(user);
                userResult = userMapper.findByThirdId(userInfo.getOpenId());
            }
            String token = Jwt.createToken(userResult);
            return new UlanqabResponse<>(new LoginResult(token, userResult));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new UlanqabResponse<>();
    }

    private Session getSession(String code) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String openIdUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+constants.APP_ID+"&secret="+constants.SECRET+"&js_code=" + code + "&grant_type=authorization_code";
        Request requestOpenId = new Request.Builder()
                .url(openIdUrl)
                .build();
        Response responseOpenId = client.newCall(requestOpenId).execute();
        String resultOpen = responseOpenId.body().string();
        return JsonUtils.jsonToObject(resultOpen, Session.class);
    }

    private AccessToken getAccessToken() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String tokenIdUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx0eefc43eb2a07681&secret=fa44e3aeb98176eae6c83d450f268c64";
        Request requestTokenId = new Request.Builder()
                .url(tokenIdUrl)
                .build();
        Response responseTokenId = client.newCall(requestTokenId).execute();
        String resultToken = responseTokenId.body().string();
        return JsonUtils.jsonToObject(resultToken, AccessToken.class);
    }
}
