package com.zzq.controller;


import com.zzq.entity.User;
import com.zzq.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zzq
 * @since 2021-09-15
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/{id}")
    public User test(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        return user;
    }

}
