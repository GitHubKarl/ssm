package com.baidu.service.impl;


import com.baidu.domain.SysLog;
import com.baidu.mapper.SysLogMapper;
import com.baidu.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogMapper.findAll();
    }

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogMapper.save(sysLog);
    }
}
