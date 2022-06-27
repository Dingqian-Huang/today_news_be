package com.david.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.david.admin.pojo.AdChannel;
import com.david.commom.pojo.PageRequest;
import com.david.commom.pojo.PageResponse;

public interface AdChannelService extends IService<AdChannel> {
    PageResponse<AdChannel> findByPage(PageRequest<AdChannel> adChannelPageRequest);
}
