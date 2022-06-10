package com.ldzy.rjxh.controller;

import com.github.pagehelper.PageInfo;
import com.ldzy.rjxh.model.Force;
import com.ldzy.rjxh.model.User;
import com.ldzy.rjxh.service.ForceService;
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
 * @Data:2022/5/26
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */

@Controller
@ResponseBody
@RequestMapping("/force")
public class ForceController {

    @Autowired
    private ForceService forceService;

    @Autowired
    private MemberService memberService;

    @PostMapping("/findForce")
    public Result<Force> findForce(Force force){
        return Result.success(forceService.findForce(force));
    }

    @PostMapping("/insertForce")
    public Result<Force> insertForce(Force force){
        User user = new User();
        user.setMemberid(force.getMemberid());
        user.setForce(force.getForceindex());
        forceService.insertForce(force);
        memberService.updateMember(user);
        return Result.success(forceService.findForce(force));
    }

    @PostMapping("/updateForce")
    public Result<Force> updateForce(Force force){
        forceService.updateForce(force);
        return Result.success(forceService.findForce(force));
    }

    @PostMapping("/deleteForce")
    public Result<Force> deleteForce(Force force){
        forceService.deleteForce(force);
        return Result.success(forceService.findForce(force));
    }

    @PostMapping("/findForces")
    public Result<PageInfo<Force>> findForces(Force force ,@RequestParam(defaultValue = "1") int pageNum){
        return Result.success(forceService.findForces(force,pageNum,10));
    }

    @PostMapping("/findForceState")
    public Result<PageInfo<Force>> findForceState(Force force ,@RequestParam(defaultValue = "1") int pageNum){
        return Result.success(forceService.findForceState(force,pageNum,10));
    }
}
