package com.ldzy.rjxh.controller;

import com.github.pagehelper.PageInfo;
import com.ldzy.rjxh.model.Bulletin;
import com.ldzy.rjxh.service.BulletinService;
import com.ldzy.rjxh.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auction:XWD
 * @Data:2022/6/1
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */
@Controller
@ResponseBody
@RequestMapping("/bulletin")
public class BulletinController {

    @Autowired
    public BulletinService bulletinService;

    @PostMapping("/findBulletin")
    public Result<Bulletin> findBulletin(Bulletin bulletin){
        return Result.success(bulletinService.findBulletin(bulletin));
    }

    @PostMapping("/insertBulletin")
    public Result<Bulletin> insertBulletin(Bulletin bulletin){
        bulletinService.insertBulletin(bulletin);
        return Result.success(bulletinService.findBulletin(bulletin));
    }

    @PostMapping("/updateBulletin")
    public Result<Bulletin> updateBulletin(Bulletin bulletin){
        bulletinService.updateBulletin(bulletin);
        return Result.success(bulletinService.findBulletin(bulletin));
    }

    @PostMapping("/deleteBulletin")
    public Result<Bulletin> deleteBulletin(Bulletin bulletin){
        bulletinService.deleteBulletin(bulletin);
        return Result.success(bulletinService.findBulletin(bulletin));
    }

    @PostMapping("/findBulletinPictures")
    public Result<Bulletin> findBulletinPictures(Bulletin bulletin){
        return Result.success(bulletinService.findBulletinPictures(bulletin));
    }

    @PostMapping("/findBulletinState")
    public Result<PageInfo<Bulletin>> findBulletinState(Bulletin bulletin ,@RequestParam(defaultValue = "1") int pageNum){
        return Result.success(bulletinService.findBulletinState(bulletin,pageNum,10));
    }
}
