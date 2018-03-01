package com.jie.shiro;

import com.jie.common.ShiroUtil;
import org.apache.shiro.subject.Subject;
import org.junit.Test;


/**
 *  shiro功能演示的数据库 db_shiro
 *  如果使用jdbc_realm功能，则必须要保证数据库中存在 users表，并且该表中必须要存在userName password字段
 * \* Created with IntelliJ IDEA.
 * \* User: wugong.jie
 * \* Date: 2018/2/26 9:06
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ShiroJdbcTest {

    @Test
    public void shiroJdbcTest(){
        //
        Subject currentUser = ShiroUtil.login("classpath:shiro/jdbc_realm.ini","wugong","123456");
    }

}