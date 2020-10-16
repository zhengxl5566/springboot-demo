//package com.zhengxl.validationdemo;
//
//import com.sun.xml.internal.ws.spi.db.DatabindingException;
//import com.zhengxl.validationdemo.vo.UserVO;
//import org.junit.jupiter.api.DisplayNameGenerator;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Date;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//
///**
// * @description:
// * @projectName:validation-demo
// * @see:com.zhengxl.validationdemo
// * @author:郑晓龙
// * @createTime:2020/8/22 10:14
// * @version:1.0
// */
//@SpringBootTest
//@AutoConfigureMockMvc
//public class UserControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void userControllerTest() throws Exception {
//        MvcResult mvcResult = this.mockMvc.perform(post("/user/add2", new UserVO()).accept(MediaType.APPLICATION_JSON))
//                .andExpect(content().encoding(StandardCharsets.UTF_8.toString()))
//                .andReturn();
//        System.out.println(new String(mvcResult.getResponse().getContentAsByteArray(), StandardCharsets.UTF_8));
//
//    }
//}
