package com.ulanqab.daily.api.user;

import com.ulanqab.daily.LocalConstants;
import com.ulanqab.daily.api.user.model.AccessToken;
import com.ulanqab.daily.api.user.model.CommonBean;
import com.ulanqab.daily.api.user.model.Session;
import com.ulanqab.daily.api.user.model.UserInfo;
import com.ulanqab.daily.utils.AesCbcUtil;
import com.ulanqab.daily.utils.JsonUtils;
import com.ulanqab.daily.wrapper.UlanqabResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/api/user")
@RestController
public class UserController {
    private LocalConstants constants = new LocalConstants();

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public UlanqabResponse login(@RequestBody String params) throws IOException {

        Long loginTime = System.currentTimeMillis();
        Long expiredTime = System.currentTimeMillis();

        CommonBean commonBean = JsonUtils.jsonToObject(params, CommonBean.class);

        OkHttpClient client = new OkHttpClient();
        String openIdUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+constants.APP_ID+"&secret="+constants.SECRET+"&js_code=" + commonBean.getCode() + "&grant_type=authorization_code";
        Request requestOpenId = new Request.Builder()
                .url(openIdUrl)
                .build();
        Response responseOpenId = client.newCall(requestOpenId).execute();
        String resultOpen = responseOpenId.body().string();
        Session session = JsonUtils.jsonToObject(resultOpen, Session.class);
        String tokenIdUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx0eefc43eb2a07681&secret=fa44e3aeb98176eae6c83d450f268c64";
        Request requestTokenId = new Request.Builder()
                .url(tokenIdUrl)
                .build();
        Response responseTokenId = client.newCall(requestTokenId).execute();
        String resultToken = responseTokenId.body().string();
        AccessToken accessToken = JsonUtils.jsonToObject(resultToken, AccessToken.class);

        try {
            String userInfoStr = AesCbcUtil.decrypt(commonBean.getEncryptedData(), session.getSession_key(), commonBean.getIv(), "UTF-8");
            UserInfo userInfo = JsonUtils.jsonToObject(userInfoStr, UserInfo.class);
            return new UlanqabResponse(new LoginResult(new Long(1), accessToken.getAccess_token(), userInfo.getNickName(), userInfo.getAvatarUrl()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new UlanqabResponse();
    }
}
