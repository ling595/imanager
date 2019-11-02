package com.three.imanager.controller;


import com.three.imanager.entity.User;
import com.three.imanager.service.StudentService;
import com.three.imanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {


    @Autowired
    StudentService studentService;

    @Autowired
    UserService userService;


    //跳转登录页面
    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    //登录
    @RequestMapping("/do_login")
    public String doLogin(Model model,User user){
        if(user == null){
            model.addAttribute("reason","登录失败");
            return "login_fail";
        }
        String name = user.getName();
        String password = user.getPassword();
        //判断手机号是否存在
        User u = userService.getByName(name);
        if(u == null){
            model.addAttribute("reason","用户不存在");
            return "login_fail";
        }
        //验证密码
        String dbPass = u.getPassword();
        if(!password.equals(dbPass)){
            model.addAttribute("reason","密码错误");
            return "login_fail";
        }
        model.addAttribute("vos", studentService.getStudents());
        return "main";
    }

    //显示全部学生信息
    @RequestMapping(path = {"/main"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {
        model.addAttribute("vos", studentService.getStudents());
        return "main";
    }


}
