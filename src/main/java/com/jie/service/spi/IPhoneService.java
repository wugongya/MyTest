package com.jie.service.spi;

import com.jie.bean.Phone;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wugong.jie
 * @date 2018/2/23
 */
public interface IPhoneService {
    Phone getById(long id);

    Phone insertPhone(Phone phone);

    Integer updatePhoneBySelected(Phone phone);

    @Transactional
    Integer saveUpdateTransfer();
}
