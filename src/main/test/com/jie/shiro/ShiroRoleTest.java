package com.jie.shiro;

import com.jie.common.ShiroUtil;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: wugong.jie
 * \* Date: 2018/2/26 9:53
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ShiroRoleTest {

    private static String shiroIniPath = "classpath:shiro/shiro_role.ini";

    @Test
    public void shiroRoleTest() {
//        shiroRoleHasRole("wugong","111111","admin");
        shiroRoleHasRoles("wugong", "111111", "admin", "super", "no");
        shiroRoleHasAllRoles("wugong", "111111", "admin", "super", "no");
        shiroRoleHasAllRoles("wugong", "111111", "admin", "super");
    }

    private void shiroRoleHasRole(String userName, String password, String role) {
        Subject currentUser = ShiroUtil.login(shiroIniPath, userName, password);
        System.out.println(currentUser.hasRole(role) ? (userName + "账号有" + role + "权限") : (userName + "账号没有" + role + "权限"));
    }

    /**
     * 多个role验证
     *
     * @Author wugong
     * @Date 2018/2/26 10:16
     * @Modify if true,please enter your name or update time
     * @params
     */
    private void shiroRoleHasRoles(String userName, String password, String... roles) {
        Subject currentUser = ShiroUtil.login(shiroIniPath, userName, password);
        List<String> roleList = Arrays.asList(roles);
        boolean results[] = currentUser.hasRoles(roleList);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i] ? (userName + "账号有" + roleList.get(i) + "权限") : (userName + "账号没有" + roleList.get(i) + "权限"));
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
    private void shiroRoleHasAllRoles(String userName, String password, String... roles) {
        Subject currentUser = ShiroUtil.login(shiroIniPath, userName, password);
        StringBuffer roleStr = new StringBuffer();
        for (int i = 0; i < roles.length; i++) {
            String role = roles[i];
            roleStr.append(role);
            if (i<roles.length-1)
                roleStr.append(",");
        }
        System.out.println(currentUser.hasAllRoles(Arrays.asList(roles)) ? (userName + "账号有全部" + roleStr + "权限") : (userName + "账号不全有" + roleStr + "权限"));
    }
}