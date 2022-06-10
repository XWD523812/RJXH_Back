package com.ldzy.rjxh.mapper;

import com.ldzy.rjxh.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auction:XWD
 * @Data:2022/5/12
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */

@Repository
@Mapper
public interface MemberMapper {

    @Select("<script>" +
            "SELECT * from member" +
            "<where>" +
            "<if test='membername != null'>and membername = #{membername} </if>" +
            "<if test='memberid != null'>and memberid = #{memberid} </if>" +
            "</where>" +
            "</script>" )
    public User findMember(User user);

    @Update("<script>" +
            "update member" +
            "<set>" +
            "<if test = 'membername != null'> membername = #{membername}, </if>" +
            "<if test = 'password != null'> password = #{password}, </if>" +
            "<if test = 'bumen != null'> bumen = #{bumen}, </if>" +
            "<if test = 'force != null'>`force` = `force` + #{force}, </if>" +
            "<if test = 'picture != null'> picture = #{picture}, </if>" +
            "<if test = 'introduce != null'> introduce = #{introduce}, </if>" +
            "<if test = 'qx != null'> qx = #{qx}, </if>" +
            "</set>" +
            "where memberid = #{memberid}" +
            "</script>")
    public void updateMember(User user);

    @Insert("INSERT INTO member(memberid,membername,bumen)" +
            "VALUES(#{memberid},#{membername},#{bumen})")
    public void insertMember(User user);

    @Delete("DELETE FROM member WHERE memberid = #{memberid}")
    public void deleteMember(User user);

    /**
     * @param user 查询所有 编号，姓名，部门，战力  不需要权限
     *               部门不为空时，查找对应部门的所有成员
     * @return
     */
    @Select("<script>" +
            "SELECT memberid,membername,bumen,`force` FROM member" +
            "<if test='bumen != null'> WHERE bumen = #{bumen} </if>" +
            " ORDER BY `force` DESC " +
            "</script>")
    public List<User> findMembers(User user);

    /**
     * @param user 根据id查询战力值，包括战力日志  需要本人或者权限<=0
     *               一对多查询，将List对象集合接受到List<Bulletin> bulletins属性里面
     *               加载成员信息里面及的所有告示
     *               column	为数据库字段名，
     *               property	为实体类属性名，
     *               jdbcType	为数据库字段数据类型，
     *               id	为是否为主键
     *               one 表示这是一个一对一的查询
     *               //@One(select = "方法全路径) 表示我们调用的方法
     * @return
     */
    @Select("SELECT memberid,membername,bumen,`force` FROM member WHERE memberid = #{memberid}")
    @Results(id = "ForceMap" , value = {
            @Result(column = "memberid",property = "memberid"),
            @Result(column = "memberid",property = "forces",
            many = @Many(select = "com.ldzy.yiban.mapper.ForceMapper.findMemberForces")
            )
    })
    public User findMemberForce(User user);

    /**
     * 一对多查询，将List对象集合接受到List<Bulletin> bulletins属性里面
     *  加载成员信息里面及的所有告示
     * @return
     */
    @Select("SELECT memberid,membername,bumen,`force` FROM member WHERE memberid = #{memberid}")
    @Results(id = "BulletinMap" , value = {
            @Result(column = "memberid",property = "memberid"),
            @Result(column = "memberid",property = "bulletins",
            many = @Many(select = "com.ldzy.yiban.mapper.BulletinMapper.findMemberBulletins")
            )
    })
    public User findMemberBulletins(User user);

}
