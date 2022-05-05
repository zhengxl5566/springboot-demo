package top.javahelper.dynamicmultipledatasources.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 支持动态切换的数据源
 * 通过重写 determineCurrentLookupKey 实现数据源切换
 * @author :Java课代表
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return RoutingDataSourceContext.getRoutingKey();
    }

}
