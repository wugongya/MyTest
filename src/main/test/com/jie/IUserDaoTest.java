package com.jie;

import com.jie.bean.Phone;
import com.jie.bean.User;
import com.jie.service.spi.IPhoneService;
import com.jie.service.spi.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: wugong.jie
 * \* Date: 2018/2/23 14:10
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDaoTest {
    @Autowired
    private IUserService userService;
    @Autowired
    private IPhoneService phoneService;

    @Test
    public void testSelectUser() throws Exception {
        long id = 1;
        User user = userService.getUserInfoById(id);
        System.out.println(user.getName()+":ssm第一步已经完成了");
    }

    @Test
    public void getUserList(){
        List<User> userList = userService.getUserList();
        for (User user : userList) {
            System.out.println(user.getName()+":run");
        }
    }

    @Test
    public void getPhone(){
        Phone phone = phoneService.getById(1);
        System.out.println(phone.getPhone());
    }

    @Test
    public void getUserEvalPhoneByUserId(){
        User userEvalPhone = userService.getUserEvalPhoneByUserId(1);
        if(null==userEvalPhone){
            System.out.println("不好意思没有查询到用户基本信息");
        }else{
            Phone phone = userEvalPhone.getPhone();
            System.out.println(userEvalPhone.getName()+":"+(null==phone?"没有手机号":phone.getPhone()));
        }
    }

    @Test
    public void getUserEvalMultiPhone(){
        User userEvalPhone = userService.getUserEvalMultiPhone(1);
        if(null==userEvalPhone){
            System.out.println("不好意思没有查询到用户基本信息");
        }else{
            List<Phone> phoneList = userEvalPhone.getPhoneList();
            System.out.println(userEvalPhone.getName());
            for (Phone phone : phoneList) {
                System.out.println(phone.getPhone());
            }
        }
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setName("平台账号");
        user.setNickName("plat");
        user.setAddTime(new Date());
        userService.insertUser(user);
        System.out.println(user.toString());
    }

    @Test
    public void updateUserBySelected(){
        User user = new User();
        user.setName("平台账号-000");
        user.setId(3L);
        userService.updateUserBySelected(user);
        this.userList();
    }

    /**
     * aop事务测试:配置方式
     * @Author wugong
     * @Date 2018/2/23 17:08
     * @Modify if true,please enter your name or update time
     * @params
     */
    @Test
    public void transferUser(){
        try {
            userService.saveOrUpdateUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 注解方式aop事务:
     * 本方法执行时，请将spring-mybatis.xml中 使用annotation注解方式配置事务 对应的位置打开，并将配置方式的位置注解
     * @Author wugong
     * @Date 2018/2/23 17:09
     * @Modify if true,please enter your name or update time
     * @params
     */
    @Test
    public void transferUserInject(){
        try {
            phoneService.saveUpdateTransfer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void userList(){
        List<User> userList = userService.getUserList();
        for (User tempUser : userList) {
            System.out.println(tempUser.getId()+"-"+tempUser.getName()+":run");
        }
    }

}