package com.ldzy.rjxh.mapper;

import com.ldzy.rjxh.model.Bulletin;
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
public interface BulletinMapper {

    @Select("SELECT * FROM `bulletin` WHERE bulletinid = #{bulletinid} AND bulletinstate = 0 ")
    public Bulletin findBulletin(Bulletin bulletin);

    @Update("<script>" +
            "UPDATE `bulletin` " +
            "<set>" +
            "<if test = 'bulletinstate != null'> bulletinstate = #{bulletinstate}, </if>" +
            "<if test = 'attendance != null'> attendance = #{attendance} + 1 ,</if> " +
            "</set>" +
            " WHERE bulletinid = #{bulletinid}" +
            "</script>")
    public void updateBulletin(Bulletin bulletin);

    @Insert("INSERT INTO `bulletin`(memberid,bulletinclass,bulletintitle,bulletinbody)" +
            "VALUES(#{memberid},#{bulletinclass},#{bulletintitle},#{bulletinbody})")
    public void insertBulletin(Bulletin bulletin);

    @Delete("DELETE FROM `bulletin` WHERE bulletinid=#{bulletinid}")
    public void deleteBulletin(Bulletin bulletin);

    /**
     *  一对多查询，将List对象集合传给Member对象
     * @return
     */
    @Select("SELECT * FROM `bulletin` " +
            "WHERE memberid = #{memberid} AND bulletinstate = 0 " +
            "ORDER BY bulletindate DESC")
    public List<Bulletin> findMemberBulletins(int memberid);

    /**
     * 一对多查询，将List对象集合接受到List<Picture> pictures属性里面
     *  加载告示里面及的所有图片
     * @return
     */
    @Select("SELECT bulletinid,memberid,bulletinclass,bulletintitle,bulletinbody,bulletindate,attendance" +
            " FROM bulletin WHERE bulletinid = #{bulletinid} AND bulletinstate = 0 ")
    @Results(id = "PicturesMap" , value = {
            @Result(column = "bulletinid",property = "bulletinid"),
            @Result(column = "bulletinid",property = "pictures",
                    many = @Many(select = "com.ldzy.yiban.mapper.PictureMapper.findBulletinPictures")
            )
    })
    public Bulletin findBulletinPictures(Bulletin bulletin);

    /**
     *  查询所有告示并分页显示
     * @return
     */
    @Select("<script>" +
            "SELECT * FROM `bulletin` " +
            "<where>" +
            "<if test='memberid != null'> memberid = #{memberid} AND bulletinstate = 0 </if>" +
            "</where>" +
            "</script>")
    public List<Bulletin> findBulletins(Bulletin bulletin);

    /**
     *  根据告示状态查询一些告示
     * @return
     */
    @Select("SELECT * FROM `bulletin` " +
            "WHERE bulletinstate = #{bulletinstate} " +
            "ORDER BY bulletindate DESC")
    public List<Bulletin> findBulletinState(Bulletin bulletin);
}
