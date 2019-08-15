package com.baidu.mapper;

import com.baidu.domain.Orders;
import com.baidu.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersMapper {
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.baidu.mapper.ProductMapper.findById"))
    })
    List<Orders> findAll();


}
