package com.example.demo.controller.generate;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.UcUser;
import com.example.demo.service.IUcUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Api("user API")
public class UcUserController {

    @Autowired
    private IUcUserService iUcUserService;

    @GetMapping("/testHello")
    @ApiOperation("获取用户")
    @ResponseBody
    public UcUser testHello(@RequestParam(value = "name", defaultValue = "World") @ApiParam("用户名称") String name) {
        UcUser user = iUcUserService.getOne(new QueryWrapper<UcUser>().lambda().eq(UcUser::getNickName, name));
        return user;
    }
}
