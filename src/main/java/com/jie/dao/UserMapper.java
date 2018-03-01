package com.jie.dao;

import com.jie.bean.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    User getUserEvalPhoneByUserId(Long userId);
    
    User getUserEvalMultiPhoneByUserId(Long userId);

    List<User> getUserList();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}