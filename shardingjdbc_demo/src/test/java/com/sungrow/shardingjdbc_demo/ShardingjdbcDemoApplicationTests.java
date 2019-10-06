package com.sungrow.shardingjdbc_demo;

import com.alibaba.fastjson.JSON;
import com.sungrow.shardingjdbc_demo.dao.OrderDao;
import com.sungrow.shardingjdbc_demo.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingjdbcDemoApplicationTests {
     @Autowired
     private OrderDao order;
     @Autowired
     private OrderService service;
    @Test
    public void contextLoads() {
        for (int i = 0; i < 10; i++) {
            int success = order.insert(new BigDecimal(String.valueOf(i)), 3L, "success");
        }

    }
   //数据查询测试
    @Test
    public void selectOrders(){
        List<Long> list=new ArrayList<>();
        list.add(386969231792537600L);
        list.add(386969231800926209L);
        List<Map<String, String>> maps = order.selectOrderByIds(list);
        System.out.println(maps);
    }

    @Test
    public void findOrders(){
        List<Long> list=new ArrayList<>();
        list.add(386969231792537600L);
        list.add(386969231800926209L);
        List<Map<String, String>> orderByList = service.findOrderByList(list);
        String s = JSON.toJSONString(orderByList);
        System.out.println(s);
    }
}
