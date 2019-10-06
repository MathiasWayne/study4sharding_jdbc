package com.sungrow.shardingjdbc_demo.service;

import com.sungrow.shardingjdbc_demo.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author:zhangl
 * @date:2019/10/4
 * @description:
 */
@Service
public class OrderService {
    @Autowired
    private OrderDao order;
    public List<Map<String,String>> findOrderByList(List<Long> ids){
        List<Map<String, String>> maps = order.selectOrderByIds(ids);
        return maps;
    }
}
