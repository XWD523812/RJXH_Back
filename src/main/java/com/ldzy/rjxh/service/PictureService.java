package com.ldzy.rjxh.service;

import com.ldzy.rjxh.model.Picture;
import org.springframework.stereotype.Service;

/**
 * @Auction:XWD
 * @Data:2022/6/1
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */
@Service
public interface PictureService {

    default Picture findPicture(Picture picture){
        return null;
    }

    default void insertPicture(Picture picture){}

    default void updatePicture(Picture picture){}

    default void deletePicture(Picture picture){
    }
}
