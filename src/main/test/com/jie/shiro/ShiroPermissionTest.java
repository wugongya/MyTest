package com.jie.shiro;

import com.jie.common.ShiroUtil;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: wugong.jie
 * \* Date: 2018/2/26 11:44
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ShiroPermissionTest {

    private static String shiroIniPath = "classpath:shiro/shiro_permission.ini";

    @Test
    public void shiroPermission(){
        shiroIsPermitted("admin","111111","user:select1");
        shiroIsPermitted("admin","111111","user:select","user:select1");
        shiroIsPermittedAll("admin","111111","user:select","user:select1");
    }

    private void shiroIsPermitted(String userName, String password, String permitted) {
        Subject currentUser = ShiroUtil.login(shiroIniPath, userName, password);
        System.out.println(currentUser.isPermitted(permitted) ? (userName + "账号有" + permitted + "权限") : (userName + "账号没有" + permitted + "权限"));
    }

    /**
     * 多个role验证
     *
     * @Author wugong
     * @Date 2018/2/26 10:16
     * @Modify if true,please enter your name or update time
     * @params
     */
    private void shiroIsPermitted(String userName, String password, String... permitteds) {
        Subject currentUser = ShiroUtil.login(shiroIniPath, userName, password);
        List<String> permittedList = Arrays.asList(permitteds);
        boolean results[] = currentUser.isPermitted(permitteds);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i] ? (userName + "账号有" + permittedList.get(i) + "权限") : (userName + "账号没有" + permittedList.get(i) + "权限"));
        }
    }

    /**
     * 全部权限的验证
     *
     * @Author wugong
     * @Date 2018/2/26 10:28
     * @Modify if true,please enter your name or update time
     * @params
     */
    private void shiroIsPermittedAll(String userName, String password, String... permitteds) {
        Subject currentUser = ShiroUtil.login(shiroIniPath, userName, password);
        StringBuffer permittedStr = new StringBuffer();
        for (int i = 0; i < permitteds.length; i++) {
            String role = permitteds[i];
            permittedStr.append(role);
            if (i<permitteds.length-1)
                permittedStr.append(",");
        }
        System.out.println(currentUser.isPermittedAll(permitteds) ? (userName + "账号有全部" + permittedStr + "权限") : (userName + "账号不全有" + permittedStr + "权限"));
    }

}