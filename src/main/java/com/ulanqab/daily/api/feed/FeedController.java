package com.ulanqab.daily.api.feed;

import com.ulanqab.daily.exception.TokenInvalidException;
import com.ulanqab.daily.jwt.Jwt;
import com.ulanqab.daily.service.MessageByLocaleService;
import com.ulanqab.daily.utils.JsonUtils;
import com.ulanqab.daily.wrapper.ListData;
import com.ulanqab.daily.wrapper.UlanqabResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FeedController {
    @Autowired
    MessageByLocaleService messageByLocaleService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private FeedMapper feedMapper;

    @RequestMapping(path = "feed/list", method = RequestMethod.GET)
    public UlanqabResponse<ListData<Feed>> feedList(@RequestParam(value = "category", defaultValue = "1") int category,
                                                    @RequestParam(value = "page", defaultValue = "1") int page,
                                                    @RequestParam(value = "count", defaultValue = "1") int count) {
        List<Feed> list = feedMapper.findByPage(category, count, count*(page-1));
        return new UlanqabResponse<>(new ListData<>(false, list));
    }

    @RequestMapping(path = "category/list", method = RequestMethod.GET)
    public UlanqabResponse<ListData<Category>> feedList(/**@RequestHeader(value = "Authorization") String token**/) throws TokenInvalidException {
//        String tokenStr = token.replace("Bearer ", "");
//        System.out.println("tokenStr" + tokenStr);
//        HashMap validToken = Jwt.validToken(tokenStr);
//        Long expiresAt = (Long) validToken.get("exp");
//        Long currentTime = System.currentTimeMillis();
//        if (expiresAt > currentTime) {
////            throw new TokenInvalidException(messageByLocaleService.getMessage("error.expires"));
//        }
//        System.out.println("expiresAt" + expiresAt);
        List<Category> list = feedMapper.findCategories();
        return new UlanqabResponse<>(new ListData<>(false, list));
    }

    @RequestMapping(path = "feed/create", method = RequestMethod.POST)
    public UlanqabResponse<Feed> createFeed(@RequestBody String params) {
        Feed feed = JsonUtils.jsonToObject(params, Feed.class);
        int result = feedMapper.insertFeed(feed);
        return new UlanqabResponse<>(result);
    }

    @RequestMapping(path = "feed/update", method = RequestMethod.POST)
    public UlanqabResponse<Feed> updateFeed(@RequestParam(value = "id") Long id,
                                            @RequestBody String params) {
        Feed feed = JsonUtils.jsonToObject(params, Feed.class);
        int result = feedMapper.updateFeed(id, feed);
        return new UlanqabResponse<>();
    }

    @RequestMapping(path = "feed/like", method = RequestMethod.POST)
    public UlanqabResponse<Feed> updateLike(@RequestBody String params) {
        return new UlanqabResponse<>();
    }
}
