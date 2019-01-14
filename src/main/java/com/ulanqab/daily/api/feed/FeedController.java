package com.ulanqab.daily.api.feed;

import com.ulanqab.daily.wrapper.ListData;
import com.ulanqab.daily.wrapper.UlanqabResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/feed")
public class FeedController {
    @Autowired
    private FeedMapper feedMapper;

    @RequestMapping(path = "list", method = RequestMethod.GET)
    public UlanqabResponse<ListData<Feed>> feedList(@RequestParam(value = "page", defaultValue = "1") int page,
                                                    @RequestParam(value = "cursor", defaultValue = "-1") Long cursor) {
        List<Feed> list = feedMapper.findAll();
        return new UlanqabResponse<>(new ListData<>(false, list));
    }
}
