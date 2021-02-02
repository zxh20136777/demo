package com.example.demo;

import com.example.demo.vo.RoleMenuVo;
import com.example.demo.vo.UcMenu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api("helloWorld API")
public class HelloWorld {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    @GetMapping("/hello")
    @ApiOperation("hello world demo")
    public String hello(@RequestParam(value = "name", defaultValue = "World") @ApiParam("输入名称，默认是 World") String name) {
        logger.info(String.format("Hello %s!", name));
        return String.format("Hello %s!", name);
    }
    @GetMapping("/menu")
    @ApiOperation("menu demo")
    public List<RoleMenuVo>  menu() {
        List<RoleMenuVo> roleMenuWithSelected = getRoleMenuWithSelected();
        return  roleMenuWithSelected;
    }

    public List<RoleMenuVo> getRoleMenuWithSelected() {
        //  全部的menu
        List<UcMenu> ucMenus = new ArrayList<>();
        UcMenu ucMenu3 = new UcMenu();
        ucMenu3.setId(4L);
        ucMenu3.setParentId(1L);
        ucMenus.add(ucMenu3);
        UcMenu ucMenu4 = new UcMenu();
        ucMenu4.setId(5L);
        ucMenu4.setParentId(1L);
        ucMenus.add(ucMenu4);
        UcMenu ucMenu5 = new UcMenu();
        ucMenu5.setId(6L);
        ucMenu5.setParentId(2L);
        ucMenus.add(ucMenu5);
        UcMenu ucMenu6 = new UcMenu();
        ucMenu6.setId(7L);
        ucMenu6.setParentId(2L);
        ucMenus.add(ucMenu6);
        UcMenu ucMenu11 = new UcMenu();
        ucMenu11.setId(1L);
        ucMenu11.setParentId(null);
        ucMenus.add(ucMenu11);
        UcMenu ucMenu1 = new UcMenu();
        ucMenu1.setId(2L);
        ucMenu1.setParentId(null);
        ucMenus.add(ucMenu1);
        UcMenu ucMenu2 = new UcMenu();
        ucMenu2.setId(3L);
        ucMenu2.setParentId(null);
        ucMenus.add(ucMenu2);

        //已选的menu
        List<UcMenu> selectedList = new ArrayList<>();
        UcMenu ucMenu66 = new UcMenu();
        ucMenu66.setId(7L);
        ucMenu66.setParentId(2L);
        selectedList.add(ucMenu66);

        UcMenu ucMenu111 = new UcMenu();
        ucMenu111.setId(1L);
        ucMenu111.setParentId(null);
        selectedList.add(ucMenu111);

        Map<Long, List<RoleMenuVo>> map = new HashMap<>();
        for (UcMenu ucMenu : ucMenus) {
            if (!map.containsKey(ucMenu.getParentId())) {
                map.put(ucMenu.getParentId(), new ArrayList<>());
            }
            RoleMenuVo current = new RoleMenuVo();
            BeanUtils.copyProperties(ucMenu, current);
            current.setSelected(selectedList.contains(ucMenu.getId()));
            if (!map.containsKey(ucMenu.getId())) {
                map.put(ucMenu.getId(), new ArrayList<>());
            }
            //对应子菜单列表
            current.setChildren(map.get(ucMenu.getId()));
            //将其加入父菜单列表
            map.get(ucMenu.getParentId()).add(current);
        }
        //获取所有父节点为null的RolemenuVoList
        return map.get(null);
    }
}
