package com.jzw.book.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/2 16:15
 */
public class ITypesServiceTest extends BaseTest {

    @Autowired
    private ITypesService iTypesService;

    @Test
    public void showAll() throws Exception {

        System.out.println(iTypesService.showAll());

    }

}