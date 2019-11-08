package com.zhengxl.multidatasource;

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
public class SecondDataSourceTest {
    @Autowired
    SecondUserDAO secondUserDAO;
    @Test
    public void testMultiDatasource(){
        System.out.println(secondUserDAO.queryAll());
    }
}
