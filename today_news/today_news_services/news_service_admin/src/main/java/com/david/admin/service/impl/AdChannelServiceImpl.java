package com.david.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.david.admin.mapper.AdChannelMapper;
import com.david.admin.pojo.AdChannel;
import com.david.admin.service.AdChannelService;
import com.david.commom.pojo.PageRequest;
import com.david.commom.pojo.PageResponse;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class AdChannelServiceImpl extends ServiceImpl<AdChannelMapper, AdChannel> implements AdChannelService {
    @Override
    public PageResponse<AdChannel> findByPage(PageRequest<AdChannel> adChannelPageRequest) {
        Long requestPage = adChannelPageRequest.getPage();
        Long requestSize = adChannelPageRequest.getSize();
        AdChannel requestBody = adChannelPageRequest.getBody();
        Page<AdChannel> objectPage = new Page<>(requestPage, requestSize);
        QueryWrapper<AdChannel> adChannelQueryWrapper = new QueryWrapper<>();
        if (null != requestBody) {
            if (!StringUtils.isNullOrEmpty(requestBody.getName())) {
                adChannelQueryWrapper.like("name", requestBody.getName());
            }
            if (null != requestBody.getStatus()) {
                adChannelQueryWrapper.eq("status", requestBody.getStatus());
            }
        }

        IPage<AdChannel> page = page(objectPage, adChannelQueryWrapper);

        return new PageResponse(page.getCurrent(), page.getSize(), page.getTotal(), page.getPages(), page.getRecords());
    }
}
