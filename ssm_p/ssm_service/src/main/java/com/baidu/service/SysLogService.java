package com.baidu.service;


import com.baidu.domain.SysLog;

import java.util.List;

public interface SysLogService {

    public void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll() throws Exception;
}
