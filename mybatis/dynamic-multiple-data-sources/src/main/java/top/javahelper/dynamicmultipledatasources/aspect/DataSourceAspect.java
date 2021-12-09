package top.javahelper.dynamicmultipledatasources.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import top.javahelper.dynamicmultipledatasources.common.RoutingDataSourceContext;
import top.javahelper.dynamicmultipledatasources.common.WithDataSource;

/**
 * @description:
 * @projectName:dynamic-multiple-data-sources
 * @see:top.javahelper.dynamicmultipledatasources.aspect
 * @author:郑晓龙
 * @createTime:2021/12/7 15:49
 * @version:1.0
 */
@Component
@Aspect
public class DataSourceAspect{
    @Around("@annotation(withDataSource)")
    public Object switchDataSource(ProceedingJoinPoint pjp, WithDataSource withDataSource) throws Throwable {

        String routingKey = withDataSource.value();
        RoutingDataSourceContext.setRoutingKey(routingKey);
        Object result = pjp.proceed();
        RoutingDataSourceContext.reset();
        return result;
    }

}
