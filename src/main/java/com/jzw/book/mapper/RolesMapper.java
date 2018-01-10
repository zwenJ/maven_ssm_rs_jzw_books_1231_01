package com.jzw.book.mapper;

import com.jzw.book.model.Roles;

public interface RolesMapper {

    int deleteByPrimaryKey(Integer roleId);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);
}