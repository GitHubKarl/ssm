package com.baidu.mapper;

import com.baidu.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
    @Select("select * from member where id=#{id}")
    Member findById(String id);
}
