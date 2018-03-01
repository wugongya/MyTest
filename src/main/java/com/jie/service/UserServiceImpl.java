package com.jie.service;

import com.jie.bean.User;
import com.jie.dao.UserMapper;
import com.jie.service.spi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: wugong.jie
 * \* Date: 2018/2/23 14:16
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户的基本信息
     * @Author wugong
     * @Date 2018/2/23 14:19
     * @Modify if true,please enter your name or update time
     * @params
     */
    @Override
    public User getUserInfoById(long id){
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取用户List
     * @Author wugong
     * @Date 2018/2/23 14:41
     * @Modify if true,please enter your name or update time
     * @params
     */
    @Override
    public List<User> getUserList(){
        return userMapper.getUserList();
    }

    /**
     * 查询用户信息并且关联一个手机号
     * @Author wugong
     * @Date 2018/2/23 15:06
     * @Modify if true,please enter your name or update time
     * @params
     */
    @Override
    public User getUserEvalPhoneByUserId(long userId){
        return userMapper.getUserEvalPhoneByUserId(userId);
    }

    /**
     * 关联用户的多个手机号
     * @Author wugong
     * @Date 2018/2/23 15:23
     * @Modify if true,please enter your name or update time
     * @params
     */
    @Override
    public User getUserEvalMultiPhone(long userId){
        return userMapper.getUserEvalMultiPhoneByUserId(userId);
    }

    /**
     * 插入用户的基本信息
     * @Author wugong
     * @Date 2018/2/23 16:05
     * @Modify if true,please enter your name or update time
     * @params
     */
    @Override
//    @Transactional
    public User insertUser(User user){
        userMapper.insertSelective(user);
        return user;
    }

    /**
     * 根据设置的信息修改用户信息
     * @Author wugong
     * @Date 2018/2/23 16:14
     * @Modify if true,please enter your name or update time
     * @params
     */
    @Override
//    @Transactional
    public Integer updateUserBySelected(User user){
        int i = 1/0;
       return userMapper.updateByPrimaryKeySelective(user);
    }
    /**
     * 修改用户信息
     * @Author wugong
     * @Date 2018/2/23 16:14
     * @Modify if true,please enter your name or update time
     * @params
     */
    @Override
//    @Transactional
    public Integer updateUser(User user){
        return userMapper.updateByPrimaryKey(user);
    }

    /**
     * 修改并且保存用户信息
     * @Author wugong
     * @Date 2018/2/23 16:58
     * @Modify if true,please enter your name or update time
     * @params
     */
    @Override
//    @Transactional
    public Integer saveOrUpdateUser(){
        User user = new User();
        user.setName("事务失败测试");
        user.setNickName("plat");
        user.setAddTime(new Date());
        this.insertUser(user);
        User oldUser = new User();
        oldUser.setId(3L);
        oldUser.setName("异常还修改成功");
        this.updateUserBySelected(oldUser);
        return 1;
    }
}