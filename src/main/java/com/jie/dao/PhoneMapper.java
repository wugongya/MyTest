package com.jie.dao;

import com.jie.bean.Phone;

public interface PhoneMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Phone record);

    int insertSelective(Phone record);

    Phone selectByPrimaryKey(Long id);

    Phone selectUserPhoneByUserId(Long userId);

    int updateByPrimaryKeySelective(Phone record);

    int updateByPrimaryKey(Phone record);
}