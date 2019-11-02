package com.three.imanager.controller;


import com.three.imanager.entity.User;
import com.three.imanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/usr")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 插入用户信息
     * @param request //通过request获取需要插入的信息
     * @return //成功返回true，失败返回false，控制台输出错误信息
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public String insertUser(HttpServletRequest request) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //非空判断
            if ("".equals(username) || "".equals(password)) {
                throw new RuntimeException("用户名或密码为空！");
            } else {
                //判断用户是否已存在
                if (true) {

                } else {
                    User user = new User();
                    user.setName(username);
                    user.setPassword(password);
                    int row = userService.insertUser(user);
                    //没有插入
                    if (row == 0)
                        return "false";
                }
            }
        } catch (RuntimeException e) {//用户名或密码为空异常
            e.printStackTrace();
            return "false";
        }
        return "true";
    }


}
