package com.zhengxl.multidatasource;

import com.zhengxl.multidatasource.dao.first.FirstUserDAO;
import com.zhengxl.multidatasource.dao.second.SecondUserDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @projectName:multidatasource
 * @see:com.zhengxl.multidatasource
 * @author:郑晓龙
 * @createTime:2019/11/8 9:29
 * @version:1.0
 */
@SpringBootTest
public class DataSourceTest {
    @Autowired
    FirstUserDAO firstUserDAO;
    @Autowired
    SecondUserDAO secondUserDAO;
    @Test
    public void testMultiDatasource(){
        System.out.println("firstDataSourceData:\n"+firstUserDAO.queryAll());
        System.out.println("secondDataSourceData:\n"+secondUserDAO.queryAll());

        System.out.println(firstUserDAO.selectById(666));
    }
}
