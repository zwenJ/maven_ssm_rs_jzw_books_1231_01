package com.jzw.book.service.impl;

import com.jzw.book.mapper.TypesMapper;
import com.jzw.book.model.Types;
import com.jzw.book.service.ITypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/2 16:08
 */
@Service
public class TypesServiceImpl implements ITypesService {

    @Autowired
    private TypesMapper typesMapper;

    @Override
    public List<Types> showAll() {
        return typesMapper.showAll();
    }



}
