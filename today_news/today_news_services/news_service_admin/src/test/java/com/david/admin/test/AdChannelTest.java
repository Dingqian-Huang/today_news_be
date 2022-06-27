package com.david.admin.test;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.david.admin.pojo.AdChannel;
import com.david.admin.service.AdChannelService;
import com.david.commom.pojo.PageRequest;
import com.david.commom.pojo.PageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdChannelTest {
    @Autowired
    AdChannelService adChannelService;

    @Test
    public void queryPageTest() {
        PageRequest<AdChannel> adChannelPageRequest = new PageRequest<>();
        adChannelPageRequest.setPage(1l);
        adChannelPageRequest.setSize(10l);
        PageResponse<AdChannel> response = adChannelService.findByPage(adChannelPageRequest);
        Assert.isTrue(1l == response.getPage(), "current page is 1");
        Assert.isTrue(10l == response.getSize(), "get 10 result");
        Assert.notEmpty(response.getList(), "list is not empty");
    }
}
