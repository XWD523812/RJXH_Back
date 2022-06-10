package com.ldzy.rjxh.controller;

import com.ldzy.rjxh.model.Picture;
import com.ldzy.rjxh.service.PictureService;
import com.ldzy.rjxh.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auction:XWD
 * @Data:2022/6/1
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */

@Controller
@ResponseBody
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    public PictureService pictureService;

    @PostMapping("/findPicture")
    public Result<Picture> findPicture(Picture picture){
        return Result.success(pictureService.findPicture(picture));
    }

    @PostMapping("/insertPicture")
    public Result<Picture> insertPicture(Picture picture){
        pictureService.insertPicture(picture);
        return Result.success(pictureService.findPicture(picture));
    }

    @PostMapping("/updatePicture")
    public Result<Picture> updatePicture(Picture picture){
        pictureService.updatePicture(picture);
        return Result.success(pictureService.findPicture(picture));
    }

    @PostMapping("/deletePicture")
    public Result<Picture> deletePicture(Picture picture){
        pictureService.deletePicture(picture);
        return Result.success(pictureService.findPicture(picture));
    }
}
