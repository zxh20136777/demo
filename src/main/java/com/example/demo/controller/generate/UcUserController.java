package com.example.demo.controller.generate;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.UcUser;
import com.example.demo.service.IUcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 用户账号表 前端控制器
 * </p>
 *
 * @author Anson
 * @since 2021-01-13
 */
@Controller
@RequestMapping("/uc-user")
public class UcUserController {

    @Autowired
    private IUcUserService iUcUserService;

    @GetMapping("/testHello")
    public UcUser testHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return iUcUserService.getOne(new QueryWrapper<UcUser>().lambda().eq(UcUser::getNickName, name));
    }
}
