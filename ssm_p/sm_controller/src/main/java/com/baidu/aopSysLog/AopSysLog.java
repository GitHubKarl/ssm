package com.baidu.aopSysLog;


import com.baidu.domain.SysLog;
import com.baidu.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

//将切面类对象的创建权交由spring管理
@Component
//切面类
@Aspect
public class AopSysLog {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;
    //定义环绕通知
    @Around("execution(* com.baidu.controller.*.*(..))")
    public Object saveLog(ProceedingJoinPoint joinPoint) {
        try {
            /**
             * 主键 无意义uuid
             * 访问时间
             * 操作者用户名
             * 访问ip
             * 访问资源url
             * 执行时长
             * 访问方法
             */
            //访问时间
            Date visitTime = new Date();
            //操作者用户名
            String username = SecurityContextHolder.getContext().getAuthentication().getName();

            long start = System.currentTimeMillis();
            //执行切入点方法
            Object proceed = joinPoint.proceed();
            //访问ip
            String ip = request.getRemoteAddr();
            //获取访问url
            String url = request.getRequestURI();

            long end = System.currentTimeMillis();
            //获取Controller方法执行时长；
            long executionTime = end - start;

            //访问方法
            //获取切入点方法所在类的字节码对象
            String className = joinPoint.getTarget().getClass().getName();
            //获取切入点方法名称
            String methodName = joinPoint.getSignature().getName();
            String method = className + "." + methodName;//???????????

            //将以上参数封装SysLog对象中；
            SysLog sysLog = new SysLog();
            sysLog.setVisitTime(visitTime);
            sysLog.setUsername(username);
            sysLog.setIp(ip);
            sysLog.setUrl(url);
            sysLog.setExecutionTime(executionTime);
            sysLog.setMethod(method);
            //调用业务层保存
            System.out.println(sysLog);
            sysLogService.save(sysLog);
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
