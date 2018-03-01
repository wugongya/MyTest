package com.jie.service;

import com.jie.bean.Phone;
import com.jie.dao.PhoneMapper;
import com.jie.service.spi.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: wugong.jie
 * \* Date: 2018/2/23 14:46
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Service
public class PhoneServiceImpl implements IPhoneService {

    @Autowired
    private PhoneMapper phoneMapper;

    @Override
    public Phone getById(long id){
        return phoneMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Phone insertPhone(Phone phone){
        phoneMapper.insert(phone);
        return phone;
    }

    @Override
    @Transactional
    public Integer updatePhoneBySelected(Phone phone){
        return phoneMapper.updateByPrimaryKeySelective(phone);
    }

    /**
     * 测试注解事务
     * @Author wugong
     * @Date 2018/2/23 17:17
     * @Modify if true,please enter your name or update time
     * @params
     */
    @Override
    @Transactional
    public Integer saveUpdateTransfer(){
        Phone phone = new Phone();
        phone.setPhone("12345678901");
        phone.setAddTime(new Date());
        phone.setAddUserId(1L);
        this.insertPhone(phone);
        Phone oldPhone = new Phone();
        oldPhone.setId(1L);
        oldPhone.setPhone("000000-异常");
        this.updatePhoneBySelected(oldPhone);
        int i= 1%0;
        return 1;
    }
}