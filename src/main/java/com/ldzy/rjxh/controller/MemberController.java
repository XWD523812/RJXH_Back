package com.ldzy.rjxh.controller;

import com.github.pagehelper.PageInfo;
import com.ldzy.rjxh.model.User;
import com.ldzy.rjxh.service.MemberService;
import com.ldzy.rjxh.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auction:XWD
 * @Data:2022/5/12
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */
@Controller
@ResponseBody
@RequestMapping("/member")
public class MemberController {
    @Autowired
    public MemberService memberService;

    @PostMapping("/findMember")
    public Result<User> findMember(User user){
        return Result.success(memberService.findMember(user));
    }

    @PostMapping("/updateMember")
    public Result<User> updateMember(User user){
        memberService.updateMember(user);
        return Result.success(memberService.findMember(user));
    }

    @PostMapping("/insertMember")
    public Result<User> insertMember(User user){
        memberService.insertMember(user);
        return Result.success(memberService.findMember(user));
    }

    @PostMapping("/deleteMember")
    public Result<User> deleteMember(User user){
        memberService.deleteMember(user);
        return Result.success(user);
    }

    @PostMapping("/findMemberForces")
    public Result<User> findMemberForce(User memberid){
        return Result.success(memberService.findMemberForce(memberid));
    }

    @PostMapping("/findMemberBulletins")
    public Result<User> findMemberBulletins(User memberid){
        return Result.success(memberService.findMemberBulletins(memberid));
    }

    @PostMapping("/findMembers")
    public Result<PageInfo<User>> findMembers(User user, @RequestParam(defaultValue = "1") Integer pageNum){
        PageInfo<User> queryResult = memberService.findMembers(user,pageNum,10); // pageNum:当前页码数，第一次进来时默认为1（首页）
        return Result.success(queryResult);
    }

}
