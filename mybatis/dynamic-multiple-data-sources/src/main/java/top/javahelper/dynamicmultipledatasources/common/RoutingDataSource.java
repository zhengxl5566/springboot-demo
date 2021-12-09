package top.javahelper.dynamicmultipledatasources.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @description:
 * @projectName:dynamic-multiple-data-sources
 * @see:top.javahelper.dynamicmultipledatasources.config
 * @author:郑晓龙
 * @createTime:2021/12/2 11:12
 * @version:1.0
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return RoutingDataSourceContext.getRoutingKey();
    }

}