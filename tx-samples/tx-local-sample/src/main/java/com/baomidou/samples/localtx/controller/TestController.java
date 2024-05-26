package com.baomidou.samples.localtx.controller;

import com.baomidou.samples.localtx.dto.PlaceOrderRequest;
import com.baomidou.samples.localtx.mapper.TestMapper;
import com.baomidou.samples.localtx.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestMapper testMapper;
    @Resource
    private PlatformTransactionManager platformTransactionManager;

    @Operation(summary = "test", description = "test")
    @PostMapping("/t")
    @Transactional
    public void test() {
        System.out.println(platformTransactionManager);
        testMapper.test();
        System.out.println(1/0);
    }
}
