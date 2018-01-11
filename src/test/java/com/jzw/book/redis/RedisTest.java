package com.jzw.book.redis;

import com.jzw.book.BaseTest;
import com.jzw.book.model.Books;
import com.jzw.book.model.Users;
import com.jzw.book.service.IBookService;
import com.jzw.book.util.PageBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/2 16:32
 */
public class RedisTest extends BaseTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IBookService iBookService;

    @Test
    public void testOne(){

        PageBean pageBean = new PageBean();
        List<Books> booksList = iBookService.showBooks(pageBean);

        System.out.println(booksList);
    }


    @Test
    public void redisTest(){

        List<Users> usersList = new ArrayList<Users>();
        Users users = null;
        for (int i = 1; i <= 100; i++) {
            users = new Users();
            users.setUserName("jzw"+i);
            users.setUserId(i);

            usersList.add(users);
        }
        System.out.println("测试使用opsForValue数据读写======");
        redisTemplate.opsForValue().set("abc", usersList);
        System.out.println("OK");
        System.out.println("测试使用opsForValue数据读取：");
        System.out.println(redisTemplate.opsForValue().get("abc"));

    }


}
