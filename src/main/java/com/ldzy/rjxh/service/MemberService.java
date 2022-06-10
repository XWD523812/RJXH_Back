package com.ldzy.rjxh.service;


import com.github.pagehelper.PageInfo;
import com.ldzy.rjxh.model.User;
import org.springframework.stereotype.Service;

/**
 * @Auction:XWD
 * @Data:2022/5/12
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */
@Service
public interface MemberService {

    default User findMember(User user){
        return null;
    }

    default void updateMember(User user){
    }

    default void insertMember(User user){
    }

    default void deleteMember(User user){}

    default User findMemberForce(User user){
        return null;
    }

    default User findMemberBulletins(User user){
        return null;
    }

    default PageInfo<User> findMembers(User user, int pageNum , int pageSize){
        return null;
    }
}
