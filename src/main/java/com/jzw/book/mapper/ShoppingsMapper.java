package com.jzw.book.mapper;

import com.jzw.book.model.Shoppings;

import java.util.List;
import java.util.Map;

public interface ShoppingsMapper {

    int deleteByPrimaryKey(Map<String, Object> map);

    int insert(Shoppings record);

    List<Shoppings> selectByPrimaryKey(Shoppings shoppings);

    int updateByPrimaryKey(Shoppings record);


}