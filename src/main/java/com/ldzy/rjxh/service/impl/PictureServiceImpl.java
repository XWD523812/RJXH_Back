package com.ldzy.rjxh.service.impl;

import com.ldzy.rjxh.mapper.PictureMapper;
import com.ldzy.rjxh.model.Picture;
import com.ldzy.rjxh.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auction:XWD
 * @Data:2022/6/1
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */
@Service
public class PictureServiceImpl implements PictureService {
    @Resource
    private PictureMapper pictureMapper;

    @Override
    public Picture findPicture(Picture picture) {
        return pictureMapper.findPicture(picture);
    }

    @Override
    public void insertPicture(Picture picture) {
        pictureMapper.insertPicture(picture);
    }

    @Override
    public void updatePicture(Picture picture) {
        pictureMapper.updatePicture(picture);
    }

    @Override
    public void deletePicture(Picture picture) {
        pictureMapper.deletePicture(picture);
    }
}
