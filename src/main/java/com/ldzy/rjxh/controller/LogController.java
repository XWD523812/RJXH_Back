package com.ldzy.rjxh.controller;

import com.ldzy.rjxh.model.User;
import com.ldzy.rjxh.service.MemberService;
import com.ldzy.rjxh.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Auction:XWD
 * @Data:2022/5/25
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */

@Controller
@ResponseBody
@RequestMapping("/log")
public class LogController {

    @Autowired
    public MemberService memberService;

    @PostMapping("/login")
    public Result<User> login(HttpSession session , User userLogin)  {

        //通过id或姓名来登录
        User user = memberService.findMember(userLogin);
        if (user.getPassword().equals(userLogin.getPassword()) && user.getQx() <= userLogin.getQx()) {
            //新建一个session用于登录控制
            session.setAttribute("member", user);
            return Result.success(user);
        }
        return Result.noUserOrPassword(userLogin);
    }

    @PostMapping("/logout")
    public Result<String> logout(HttpSession session){
        session.removeAttribute("member");
        return Result.success("已退出登录");
    }

}