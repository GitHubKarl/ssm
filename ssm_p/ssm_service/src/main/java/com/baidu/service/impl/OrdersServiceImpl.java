package com.baidu.service.impl;

import com.baidu.domain.Orders;
import com.baidu.mapper.OrdersMapper;
import com.baidu.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> findAll(int page,int size) {
        PageHelper.startPage(page, size);
        List<Orders> ordersList = ordersMapper.findAll();
        return ordersList;
    }

    @Override
    public Orders findById(String ordersId) {
        return ordersMapper.findById(ordersId);
    }

}
