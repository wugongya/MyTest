package com.jie.controller;

import com.jie.bean.User;
import com.jie.common.OperationLogger;
import com.jie.service.spi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: wugong.jie
 * \* Date: 2018/2/23 14:20
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Controller
@RequestMapping("/manage/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @OperationLogger(modelName = "userDetailModelName", option = "id")
    @RequestMapping("{id}")
    public String userDetail(@PathVariable("id") Long id, Model model){
        try {
            User user = userService.getUserInfoById(1);
            model.addAttribute("user",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user";
    }

    public void saveUser(User user,Model model){

    }

}