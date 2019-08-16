package com.baidu.mapper;

import com.baidu.domain.Orders;
import com.baidu.domain.Product;
import com.baidu.domain.Member;
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

    @Select("select * from orders where id =#{orderId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.baidu.mapper.ProductMapper.findById")),
            @Result(property = "travellers",column = "Id",javaType = List.class,many = @Many(select = "com.baidu.mapper.TravellerMapper.findByOrdersId")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.baidu.mapper.MemberMapper.findById"))
    })
    Orders findById(String orderId);

}
