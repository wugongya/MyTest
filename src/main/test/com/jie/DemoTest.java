package com.jie;

import com.alibaba.fastjson.JSON;
import com.jie.bean.User;
import com.jie.common.ClassParam;
import org.junit.Test;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: wugong.jie
 * \* Date: 2018/2/24 9:44
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class DemoTest {

    @Test
    public void demoTest(){
        User user = new User();
        user.setId(1L);
        ClassParam.getParameters(user.getClass());
//        ClassParam.getFieldsValue(user);
    }

    @Test
    public void testForNameForParam(){
        try {
            System.out.println("是否是基本数据类型："+Class.forName("com.jie.bean.Phone").isPrimitive());
            System.out.println("是否是基本数据类型："+Class.forName("java.lang.Long").isPrimitive());
            ClassParam.getTypeDesc(Class.forName("com.jie.bean.Phone"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTypeDesc(){
        try {
            System.out.println(ClassParam.getTypeDesc(Class.forName("com.jie.bean.User")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void deserializePojo(){
        User user = new User();
        user.setId(1L);
        user.setName("wugong");
        System.out.println(JSON.toJSONString(user));
    }
}