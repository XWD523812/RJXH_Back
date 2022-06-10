package com.ldzy.rjxh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldzy.rjxh.mapper.MemberMapper;
import com.ldzy.rjxh.model.User;
import com.ldzy.rjxh.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auction:XWD
 * @Data:2022/5/19
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    public MemberMapper memberMapper;

    @Override
    public User findMember(User user) {
        return memberMapper.findMember(user);
    }

    @Override
    public void updateMember(User user) {
        memberMapper.updateMember(user);
    }

    @Override
    public void insertMember(User user) {
        memberMapper.insertMember(user);
    }

    @Override
    public void deleteMember(User user) {
        memberMapper.deleteMember(user);
    }

    @Override
    public User findMemberForce(User user) {
        return memberMapper.findMemberForce(user);
    }

    @Override
    public User findMemberBulletins(User user) {
        return memberMapper.findMemberBulletins(user);
    }

    @Override
    public PageInfo<User> findMembers(User user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> lists=memberMapper.findMembers(user);
        return new PageInfo<User>(lists);
    }

}
