package com.sungrow.shardingjdbc_demo.controller;

import com.alibaba.fastjson.JSON;
import com.sungrow.shardingjdbc_demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

import java.util.List;
import java.util.Map;

/**
 * @author:zhangl
 * @date:2019/10/4
 * @description:
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("findOrders")
    public String selectOrderByIds(@RequestParam("ids") String ids){
        List<Long> idList=new ArrayList<>();
        for (String s : ids.split(",")) {
            idList.add(Long.valueOf(s));
        }
        List<Map<String, String>> orderByList = orderService.findOrderByList(idList);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(orderByList);
    }
}
