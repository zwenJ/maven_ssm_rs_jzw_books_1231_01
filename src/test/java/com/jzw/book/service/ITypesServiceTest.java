package com.jzw.book.service;

import com.jzw.book.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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