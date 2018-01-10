package com.jzw.book.service.impl;

import com.jzw.book.mapper.AddressMapper;
import com.jzw.book.model.Address;
import com.jzw.book.service.IBaseService;
import com.jzw.book.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/5 20:47
 */
@Service("AddressServiceImpl")
public class AddressServiceImpl implements IBaseService<Address> {


    @Autowired
    private AddressMapper addressMapper;

    /**
     * 查询的方法
     *
     * @param address
     * @return
     */
    @Override
    public List<Address> showAll(Address address) {
        return null;
    }

    /**
     * 查询的方法
     *
     * @param pageBean
     * @return
     */
    @Override
    public List<Address> showAll(PageBean pageBean) {
        return null;
    }

    /**
     * 查询单个
     *
     * @param integer
     * @return
     */
    @Override
    public Address showSole(Integer integer) {
        return null;
    }

    /**
     * 添加保存的方法
     *
     * @param address
     * @return
     */
    @Override
    public boolean saveObj(Address address) {
        int insert = addressMapper.insert(address);
        if (insert > 0) return true;

        return false;
    }

    /**
     * 修改的方法
     *
     * @param address
     * @return
     */
    @Override
    public boolean updateObj(Address address) {
        return false;
    }

    /**
     * 删除的方法
     *
     * @param integer
     * @return
     */
    @Override
    public boolean deleteObj(Integer integer) {
        return false;
    }
}
