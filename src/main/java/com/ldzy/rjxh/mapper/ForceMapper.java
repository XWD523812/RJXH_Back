package com.ldzy.rjxh.mapper;
import com.ldzy.rjxh.model.Force;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auction:XWD
 * @Data:2022/5/26
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */

@Mapper
@Repository
public interface ForceMapper {

    @Select("SELECT * FROM `force` WHERE forceid = #{forceid} AND forcestate=0")
    public Force findForce(Force force);

    @Update("<script>" +
            "UPDATE `force` " +
            "<set>" +
            "<if test = 'memberid != null'> memberid = #{memberid}, </if>" +
            "<if test = 'forceindex != null'> forceindex = #{forceindex}, </if>" +
            "<if test = 'forceadddata != null'> forceadddata = #{forceadddata}, </if>" +
            "<if test = 'forcestate != null'> forcestate = #{forcestate}, </if>" +
            "</set>" +
            "WHERE forceid = #{forceid}" +
            "</script>")
    public void updateForce(Force force);

    @Insert("INSERT INTO `force`(memberid,forceindex,forceadddata)" +
            "VALUES(#{memberid},#{forceindex},#{forceadddata})")
    public void insertForce(Force force);

    @Delete("DELETE FROM `force` WHERE forceid=#{forceid}")
    public void deleteForce(Force force);

    /**
     *  查询所有日志并分页显示
     * @return
     */
    @Select("SELECT * FROM `force` " +
            "WHERE memberid = #{memberid} AND forcestate=0 " +
            "ORDER BY forcedate DESC")
    public List<Force> findMemberForces(int memberid);

    /**
     *  查询所有日志并分页显示 并选择是否根据成员查询
     * @return
     */
    @Select("<script>" +
            "SELECT * FROM `force` " +
            "<where>" +
            "<if test='memberid != null'> memberid = #{memberid} AND forcestate=0 </if>" +
            "</where>" +
            "</script>")
    public List<Force> findForces(@Param(value="memberid")Integer memberid);

    /**
     *  根据战力值状态查询一些告示
     * @return
     */
    @Select("SELECT * FROM `force` " +
            "WHERE forcestate = #{forcestate} " +
            "ORDER BY forcedate DESC")
    public List<Force> findForceState(Force force);
}
