package com.jie.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: wugong.jie
 * \* Date: 2018/2/26 9:00
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ShiroUtil {

    /**
     * shiro配置链接
     * @Author wugong
     * @Date 2018/2/26 9:03
     * @Modify if true,please enter your name or update time
     * @params
     */
    public static Subject login(String shiroConfigPath, String userName, String password) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(shiroConfigPath);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            currentUser.login(token);
            System.out.println("身份认证成功");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("身份认证异常");
        }
        return currentUser;
    }

}