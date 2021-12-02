package top.javahelper.dynamicmultipledatasources.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @description:
 * @projectName:dynamic-multiple-data-sources
 * @see:top.javahelper.dynamicmultipledatasources.config
 * @author:郑晓龙
 * @createTime:2021/12/2 11:12
 * @version:1.0
 */
public class MultipleDataSource extends AbstractRoutingDataSource implements InitializingBean, DisposableBean {

    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }

    @Override
    public void destroy() throws Exception {

    }
}
