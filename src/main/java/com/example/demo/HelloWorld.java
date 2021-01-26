package com.example.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
