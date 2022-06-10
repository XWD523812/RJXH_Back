package com.ldzy.rjxh.mapper;

import com.ldzy.rjxh.model.Picture;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auction:XWD
 * @Data:2022/6/1
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */
@Mapper
@Repository
public interface PictureMapper {

    @Select("SELECT * FROM `picture` WHERE pictureid = #{pictureid}")
    public Picture findPicture(Picture picture);

    @Update("UPDATE `picture` SET pictureurl = #{pictureurl} WHERE pictureid = #{pictureid}")
    public void updatePicture(Picture picture);

    @Insert("INSERT INTO `picture`(bulletinid,pictureurl)" +
            "VALUES(#{bulletinid},#{pictureurl})")
    public void insertPicture(Picture picture);

    @Delete("DELETE FROM `picture` WHERE pictureid=#{pictureid}")
    public void deletePicture(Picture picture);

    /**
     *  一对多查询，将List对象集合传给Member对象
     * @return
     */
    @Select("SELECT bulletinid,pictureurl FROM `picture` WHERE bulletinid = #{bulletinid} ORDER BY picturedate DESC")
    public List<Picture> findBulletinPictures(int bulletinid);
}
