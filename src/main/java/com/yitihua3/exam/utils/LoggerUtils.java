package com.yitihua3.exam.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect			//记得要有这两个注解
@Component

public class LoggerUtils {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    final String Pointcut = "execution(public * com.yitihua3.exam.controller..*.*(..))";

    //定义切入点,拦截controller包其子包下的所有类的所有方法
    @Pointcut(Pointcut)
    public void controllerMethod() {
    }

    @Around(Pointcut)
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        //打印当前的请求路径，打印调用controller的哪个方法
        logger.debug("-------------------以下是url--------------------------");
        logger.debug("当前url为" + request.getRequestURI());
        logger.debug("-------------------以下是方法名--------------------------");
        logger.debug("环绕通知的目标方法名：" + proceedingJoinPoint.getSignature().getName());
        //调用下方的前置通知//obj之前可以写目标方法执行前的逻辑
        processInputArg(proceedingJoinPoint.getArgs());
        logger.debug("-------------------以下是原函数--------------------------");
        //调用控制器的原方法
        Object obj = proceedingJoinPoint.proceed();
    //调用下方的后置通知
        processOutPutObj(obj);
        //控制器方法返回值
        return obj;
    }


    //处理返回对象
    public void processOutPutObj(Object obj) {//后置通知
        logger.debug("-------------------以下是返回值--------------------------");
        if (obj != null) {
            logger.debug("方法的返回值为" + obj.getClass().getName() + "类，内容为" + obj.toString());
        } else {
            logger.debug("返回值为空");
        }

    }

    private static final String WITHOUT_ARGS="方法无参数";
    // 处理输入参数			//可变参数
    public void processInputArg(Object[] args) {//前置通知
        logger.debug("-------------------以下是参数--------------------------");
        if (args.length == 0) {
            logger.debug(WITHOUT_ARGS);
        } else {
            int i=1;
            for (Object arg : args) {
                if(arg==null) {
                    logger.debug("第"+i+"个参数为null");
                } else {
                    logger.debug("传入第"+i+"个的参数" + arg.getClass().getName() + "类，内容为" + arg.toString());
                }
                i++;
            }
        }
    }
}