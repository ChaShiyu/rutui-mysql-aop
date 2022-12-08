package cn.rutui.mysqlaop.aop;

import cn.rutui.mysqlaop.base.BaseInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class BaseInfoAop {

    @Pointcut("@annotation(cn.rutui.mysqlaop.aop.BaseInfoAnnotation))")
    public void setBaseInfo() {
    }

    @Around("setBaseInfo()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        BaseInfoAnnotation annotation = signature.getMethod().getAnnotation(BaseInfoAnnotation.class);
        OperateTypeEnum value = annotation.value();
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            BaseInfo arg = (BaseInfo) args[0];
            Map<String, String> userInfo = getUserInfo();
            if (value == OperateTypeEnum.ADD) {
                arg.setCreatorId(Long.valueOf(userInfo.get("id")));
                arg.setCreatorName(userInfo.get("name"));
                arg.setOptTime(new Date());
            } else if (value == OperateTypeEnum.UPDATE || value == OperateTypeEnum.DELETE) {
                arg.setCreatorId(Long.valueOf(userInfo.get("id")));
                arg.setCreatorName(userInfo.get("name"));
                arg.setOptTime(new Date());
            }
        }
        return joinPoint.proceed(args);
    }

    private Map<String, String> getUserInfo() {
        // get user info by session
        HashMap<String, String> map = new HashMap<>();
        map.put("id", "10");
        map.put("name", "namename");
        return map;
    }
}