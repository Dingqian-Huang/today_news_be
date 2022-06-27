package com.david.admin.controller;

import com.david.admin.pojo.AdChannel;
import com.david.admin.service.AdChannelService;
import com.david.commom.pojo.PageRequest;
import com.david.commom.pojo.PageResponse;
import com.david.commom.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/channel")
public class AdChannelController {
    @Autowired
    private AdChannelService adChannelService;

    @PostMapping("/search")
    public Result<PageResponse<AdChannel>> search(@RequestBody PageRequest<AdChannel> pageRequest) {
        PageResponse<AdChannel> pageInfo = adChannelService.findByPage(pageRequest);
        return Result.ok(pageInfo);
    }

    @GetMapping("/{id}")
    public Result<AdChannel> findById(@PathVariable("id") Integer id) {
        AdChannel byId = adChannelService.getById(id);
        return Result.ok(byId);
    }

    @PostMapping
    public Result<AdChannel> insert(@RequestBody AdChannel adChannel) {
        boolean saved = adChannelService.save(adChannel);
        if (saved) {
            return Result.ok();
        }
        return Result.error();
    }

    @DeleteMapping("/{id}")
    public Result<AdChannel> delete(@PathVariable("id") Integer id) {
        boolean removed = adChannelService.removeById(id);
        if (removed) {
            return Result.ok();
        }
        return Result.error();
    }

    @PutMapping
    public Result<AdChannel> updateById(@RequestBody AdChannel adChannel) {
        if (null == adChannel || null == adChannel.getId()) {
            return Result.errorMessage("channel id missed");
        }
        boolean updated = adChannelService.updateById(adChannel);
        if (updated) {
            return Result.ok();
        }
        return Result.error();
    }
}
