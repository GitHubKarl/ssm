package com.baidu.mapper;

import com.baidu.domain.Orders;
import com.baidu.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {

    //按id查询
    @Select("select * from product where id =#{id}")
    Product findById(String id);

    //查询所有
    @Select("select * from product")
    List<Product> findAll();

    //添加一个产品
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;
}
