package com.example.demo.service.impl;

import com.example.demo.entity.UcUser;
import com.example.demo.mapper.generate.UcUserMapper;
import com.example.demo.service.IUcUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账号表 服务实现类
 * </p>
 *
 * @author Anson
 * @since 2021-01-13
 */
@Service
public class UcUserServiceImpl extends ServiceImpl<UcUserMapper, UcUser> implements IUcUserService {

}
