package com.baidu.controller;

import com.baidu.domain.Orders;
import com.baidu.service.OrdersService;
import com.baidu.service.impl.OrdersServiceImpl;
import com.github.pagehelper.PageInfo;
import javafx.scene.media.MediaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersServiceImpl;

    //查询所有订单
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "3") Integer pageSize){
        List<Orders> ordersList = ordersServiceImpl.findAll(page,pageSize);
        ModelAndView mv=new ModelAndView();
        //PageInfo就是一个分页的的bean
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.setViewName("orders-page-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

    //订单详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id" ,required = true) String ordersId){
        ModelAndView mv =new ModelAndView();
        Orders orders = ordersServiceImpl.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

}
