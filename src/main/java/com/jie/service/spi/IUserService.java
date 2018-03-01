package com.jie.service.spi;

import com.jie.bean.User;

import java.util.List;

/**
 * @author wugong.jie
 * @date 2018/2/23
 */
public interface IUserService {
    User getUserInfoById(long id);

    List<User> getUserList();

    User getUserEvalPhoneByUserId(long userId);

    User getUserEvalMultiPhone(long userId);

    User insertUser(User user);

    Integer updateUserBySelected(User user);

    Integer updateUser(User user);

    Integer saveOrUpdateUser();
}
