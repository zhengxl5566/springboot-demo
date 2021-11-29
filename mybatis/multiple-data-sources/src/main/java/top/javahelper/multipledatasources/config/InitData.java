package top.javahelper.multipledatasources.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import top.javahelper.multipledatasources.mapper.first.FirstUserMapper;
import top.javahelper.multipledatasources.mapper.second.SecondUserMapper;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author:Java课代表
 * @createTime:2021/11/3 23:13
 */
@Configuration
public class InitData {
    @Autowired
    FirstUserMapper firstUserMapper;
    @Autowired
    SecondUserMapper secondUserMapper;

    @PostConstruct
    public void init() {
        firstUserMapper.init();
        secondUserMapper.init();

    }
}
