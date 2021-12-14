package top.javahelper.dynamicmultipledatasources.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import top.javahelper.dynamicmultipledatasources.common.RoutingDataSourceContext;
import top.javahelper.dynamicmultipledatasources.common.WithDataSource;

/**
 * 数据源切面，根据注解 @WithDataSource 的 value 切换数据源
 * @author:郑晓龙
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Aspect
@Component
public class DataSourceAspect {
    @Around("@annotation(withDataSource)")
    public Object switchDataSource(ProceedingJoinPoint pjp, WithDataSource withDataSource) throws Throwable {

        // 1.获取 @WithDataSource 注解中指定的数据源
        String routingKey = withDataSource.value();
        // 2.设置数据源上下文
        RoutingDataSourceContext.setRoutingKey(routingKey);
        // 3.使用设定好的数据源处理业务
        Object result = pjp.proceed();
        // 4.清空数据源上下文
        RoutingDataSourceContext.reset();

        return result;
    }

}

